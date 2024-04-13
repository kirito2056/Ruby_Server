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
    public String Signup(String emailAddress, String user_type, String platform) throws JsonProcessingException {
        UserEntity newUser = new UserEntity();

        Map<String, String> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        //이메일 빈값임
        if (emailAddress == null) {
            map.put("res", "50");
            map.put("message", "email");
            return objectMapper.writeValueAsString(map);
        }

        newUser.setEmail(emailAddress);
        newUser.setUser_type(UserType.valueOf(user_type));
        newUser.setPlatform(PlatformType.valueOf(platform));
        userRepository.save(newUser);

        return null;
    }
}
