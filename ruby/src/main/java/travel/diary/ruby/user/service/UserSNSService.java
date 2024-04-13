package travel.diary.ruby.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface UserSNSService {


    String Signup(String emailAddress, String user_type, String platform) throws JsonProcessingException;
}
