package travel.diary.ruby.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import travel.diary.ruby.user.service.UserSNSService;

@RestController
@RequestMapping("auth")
public class UserController {
    private final UserSNSService userSNSService;
    @Autowired
    public UserController(UserSNSService userSNSService) {
        this.userSNSService = userSNSService;
    }

    @RequestMapping("/{userType}/{platform}")
    public ResponseEntity<?> authLogin(@RequestParam String emailAddress, @RequestParam String password, @PathVariable String userType, @PathVariable String platform) throws JsonProcessingException {
        return ResponseEntity.ok(userSNSService.Signup(emailAddress, password, userType, platform));
    }
}
