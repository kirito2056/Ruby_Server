package travel.diary.ruby.article.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import travel.diary.ruby.article.entity.ArticleEntity;
import travel.diary.ruby.article.entity.ArticleRequestDTO;
import travel.diary.ruby.article.repository.ArticleRepository;
import travel.diary.ruby.article.service.ArticleService;

import java.util.HashMap;
import java.util.Map;

@Service
@EnableJpaRepositories
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Object saveArticle(ArticleRequestDTO newArticle, String user_id) {
        Map<String, Object> map = new HashMap<>();
        ArticleEntity articleEntity = new ArticleEntity();

        articleEntity.setLon(newArticle.getLon());
        articleEntity.setLat(newArticle.getLat());
        articleEntity.setTitle(newArticle.getTitle());
        articleEntity.setContent(newArticle.getContent());
        articleEntity.setUserId(Long.parseLong(user_id));

        map.put("res", "200");
        map.put("message", "save");

        articleRepository.save(articleEntity);
        return map;
    }

    @Override
    public Object getArticle(String article_id) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        ArticleEntity gotArticle = articleRepository.findByArticleId(article_id);

        map.put("res", "200");
        map.put("message", "get");
        map.put("article_id", gotArticle.getArticleId());
        map.put("articleEntity", gotArticle);
        return objectMapper.writeValueAsString(map);
    }
}
