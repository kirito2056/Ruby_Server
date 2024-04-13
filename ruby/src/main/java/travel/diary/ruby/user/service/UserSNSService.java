package travel.diary.ruby.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface UserSNSService {
    Object Signup(String emailAddress, String password, String user_type, String platform) throws JsonProcessingException;
}
