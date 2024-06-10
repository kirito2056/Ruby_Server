package travel.diary.ruby.user.service.impl;

import org.springframework.stereotype.Service;
import travel.diary.ruby.user.entity.dto.UserSignupDTO;
import travel.diary.ruby.user.service.UserService;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Object Signup(UserSignupDTO newUser) {
        Map<String, Object> map = new HashMap<>();
        map.put("res", 200);

        return map;
    }
}
