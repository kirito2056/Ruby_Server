package travel.diary.ruby.hmm;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import travel.diary.ruby.user.entity.UserEntity;
import travel.diary.ruby.user.repository.UserRepository;

import java.util.List;

@Controller
public class hehe {
    private final UserRepository userRepository;

    public hehe(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/christmas/tree")
    public ResponseEntity<?> getAllUser() {
        List<UserEntity> UserList = userRepository.findAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("UserList", UserList);
        return ResponseEntity.ok("findallusers");
    }
}
