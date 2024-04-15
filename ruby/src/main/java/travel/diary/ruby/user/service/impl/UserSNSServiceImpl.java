package travel.diary.ruby.user.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.diary.ruby.user.entity.PlatformType;
import travel.diary.ruby.user.entity.UserEntity;
import travel.diary.ruby.user.entity.UserType;
import travel.diary.ruby.user.repository.UserRepository;
import travel.diary.ruby.user.service.UserSNSService;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserSNSServiceImpl implements UserSNSService {

    private final UserRepository userRepository;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserSNSServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Object Signup(String emailAddress, String password, String user_type, String platform) throws JsonProcessingException {
        UserEntity newUser = new UserEntity();
        Map<String, String> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        //이메일 빈값임
        if (emailAddress == null) {
            map.put("res", "0");
            map.put("message", "email");
            return map;
        }

        if ( "NORMAL".equalsIgnoreCase(user_type)) {
            return normalSignup(emailAddress, password, platform);
        }

        if (userRepository.findByEmail(emailAddress) == null) {
            newUser.setEmail(emailAddress);
            newUser.setUser_type(UserType.valueOf(user_type.toUpperCase()));
            newUser.setPlatform(PlatformType.valueOf(platform.toUpperCase()));
            newUser.setPassword("__empty__");
            userRepository.save(newUser);
            map.put("res", "200");
            map.put("message", "signup");
            map.put("user_id", userRepository.findByEmail(emailAddress).getUserId().toString());
            log.info("signup - " + user_type + " - " + platform + " - " + emailAddress);
            log.info(objectMapper.writeValueAsString(map));
            return map;
        } else {
            map.put("res", "200");
            map.put("message", "login");
            map.put("user_id", userRepository.findByEmail(emailAddress).getUserId().toString());
            map.put("user_entity", String.valueOf(userRepository.findByEmail(emailAddress)));
            log.info("Login - NORMAL" + " - " + platform + " - " + emailAddress);
            log.info(objectMapper.writeValueAsString(map));

            return objectMapper.writeValueAsString(map);
        }
    }

    public Object normalSignup(String emailAddress, String password, String platform) throws JsonProcessingException {
        UserEntity newUser = new UserEntity();
        Map<String, String> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        if (userRepository.findByEmail(emailAddress) == null) {
            newUser.setEmail(emailAddress);
            newUser.setUser_type(UserType.valueOf("NORMAL"));
            newUser.setPlatform(PlatformType.valueOf(platform.toUpperCase()));

            //password 암호화 처리 구현하기--------------------
            if (password.equals("empty")) newUser.setPassword("__empty__");
            else newUser.setPassword(password);

            //password 암호화 처리 구현하기--------------------


            userRepository.save(newUser);
            map.put("res", "200");
            map.put("message", "signup");
            map.put("user_id", userRepository.findByEmail(emailAddress).getUserId().toString());
            log.info("signup - NORMAL" + " - " + platform + " - " + emailAddress);
            log.info(objectMapper.writeValueAsString(map));
            return map;
        } else {
            //이메일로 유저 뽑아서 SNS로그인 했으면 알려주기
            if ( !"NORMAL".equalsIgnoreCase(userRepository.findByEmail(emailAddress).getUser_type().toString())) {
                map.put("res", "0");
                map.put("message", "already registered with SNS");
                map.put("user_id", userRepository.findByEmail(emailAddress).getUserId().toString());
                log.info(objectMapper.writeValueAsString(map));
                return map;
            }

            if (password.equals(userRepository.findByEmail(emailAddress).getPassword())) {
                map.put("res", "0");
                map.put("message", "password");
            }
            map.put("res", "200");
            map.put("user_entity", String.valueOf(userRepository.findByEmail(emailAddress)));
            map.put("user_id", userRepository.findByEmail(emailAddress).getUserId().toString());
            log.info("Login - NORMAL" + " - " + platform + " - " + emailAddress);
            log.info(objectMapper.writeValueAsString(map));

            return objectMapper.writeValueAsString(map);
        }
    }
}
