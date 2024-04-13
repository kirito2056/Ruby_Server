package travel.diary.ruby.service;

import travel.diary.ruby.article.entity.ArticleEntity;

public interface ArticleService {
    Object saveArticle(ArticleEntity newArticle);
}
