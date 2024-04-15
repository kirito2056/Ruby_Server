package travel.diary.ruby.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import travel.diary.ruby.article.entity.ArticleEntity;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    @Query("SELECT a from ArticleEntity a where a.articleId =:articleId")
    ArticleEntity findByArticleId(String articleId);

    @Query("SELECT a from ArticleEntity a")
    List<ArticleEntity> findAllArticles();
}
