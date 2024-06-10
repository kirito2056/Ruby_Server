package travel.diary.ruby.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import travel.diary.ruby.user.entity.dto.UserSignupDTO;
import travel.diary.ruby.user.service.UserSNSService;
import travel.diary.ruby.user.service.UserService;

@RestController
@RequestMapping("auth")
public class UserController {
    private final UserSNSService userSNSService;
    private final UserService userService;

    @Autowired
    public UserController(UserSNSService userSNSService, UserService userService) {
        this.userSNSService = userSNSService;
        this.userService = userService;
    }

    @RequestMapping("/{userType}/{platform}")
    public ResponseEntity<?> authLogin(@RequestParam String emailAddress, @RequestParam String password, @PathVariable String userType, @PathVariable String platform) throws JsonProcessingException {
        return ResponseEntity.ok(userSNSService.Signup(emailAddress, password, userType, platform));
    }

    @RequestMapping("/login")
    public ResponseEntity<?> normalLogin(@RequestBody UserSignupDTO newUser) throws JsonProcessingException {
        return ResponseEntity.ok(userService.Signup(newUser));
    }
}
