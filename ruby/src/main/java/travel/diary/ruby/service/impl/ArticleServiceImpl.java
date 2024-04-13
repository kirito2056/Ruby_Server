package travel.diary.ruby.service.impl;

import org.springframework.stereotype.Service;
import travel.diary.ruby.article.entity.ArticleEntity;
import travel.diary.ruby.article.repository.ArticleRepository;
import travel.diary.ruby.service.ArticleService;

import java.util.HashMap;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Object saveArticle(ArticleEntity newArticle) {
        Map<String, Object> map = new HashMap<>();
        map.put("res", "200");
        map.put("message", "save");

        articleRepository.save(newArticle);
        return map;
    }
}
