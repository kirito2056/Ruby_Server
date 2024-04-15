package travel.diary.ruby.hmm;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import travel.diary.ruby.article.entity.ArticleEntity;
import travel.diary.ruby.article.repository.ArticleRepository;
import travel.diary.ruby.user.entity.UserEntity;
import travel.diary.ruby.user.repository.UserRepository;
import java.util.List;

@Controller
public class hehe {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public hehe(UserRepository userRepository, ArticleRepository articleRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    @RequestMapping("christmas/tree")
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok(userRepository.findAllUsers());
    }

    @RequestMapping("stay/with/me")
    public ResponseEntity<?> getAllArticle(){
        return ResponseEntity.ok(articleRepository.findAll());
    }
}
