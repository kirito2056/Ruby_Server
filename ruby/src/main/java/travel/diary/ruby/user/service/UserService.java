package travel.diary.ruby.user.service;

import travel.diary.ruby.user.entity.dto.UserSignupDTO;

public interface UserService {
    Object Signup(UserSignupDTO newUser);
}
