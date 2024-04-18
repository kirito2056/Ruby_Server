package travel.diary.ruby.article.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import travel.diary.ruby.article.entity.ArticleRequestDTO;

public interface ArticleService {
    Object saveArticle(ArticleRequestDTO newArticle, String user_id);

    Object getArticle(String article_id) throws JsonProcessingException;

    Object deleteArticle(String article_id);

    Object updateArticle(ArticleRequestDTO requestDTO, String postId);
}
