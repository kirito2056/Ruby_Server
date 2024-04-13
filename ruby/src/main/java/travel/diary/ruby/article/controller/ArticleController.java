package travel.diary.ruby.article.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import travel.diary.ruby.article.entity.ArticleEntity;
import travel.diary.ruby.service.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping("/save")
    public ResponseEntity<?> saveArticle(ArticleEntity newArticle) {
        return ResponseEntity.ok(articleService.saveArticle(newArticle));
    }
}
