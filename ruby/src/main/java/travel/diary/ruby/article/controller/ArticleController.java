package travel.diary.ruby.article.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import travel.diary.ruby.article.entity.ArticleRequestDTO;
import travel.diary.ruby.article.service.ArticleService;

@RestController
@RequestMapping("article")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
    @GetMapping("/get/{post_id}")
    public ResponseEntity<?> getArticle(@PathVariable Long post_id) throws JsonProcessingException {
        return ResponseEntity.ok(articleService.getArticle(post_id.toString()));
    }

    @RequestMapping("/save/{user_id}")
    public ResponseEntity<?> saveArticle(@RequestPart("article") ArticleRequestDTO newArticle, @PathVariable String user_id) {
        return ResponseEntity.ok(articleService.saveArticle(newArticle, user_id));
    }

    @RequestMapping("/put/{post_id}")
    public ResponseEntity<?> updateArticle(@RequestPart("article") ArticleRequestDTO requestDTO, @PathVariable String post_id) {
        return ResponseEntity.ok(articleService.updateArticle(requestDTO, post_id));
    }

    @DeleteMapping("/delete/{articleId}")
    public ResponseEntity<?> getArticle(@PathVariable String articleId) throws JsonProcessingException {
        return ResponseEntity.ok(articleService.getArticle(articleId));
    }
}
