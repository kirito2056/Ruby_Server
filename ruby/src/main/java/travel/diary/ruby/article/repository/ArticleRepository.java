package travel.diary.ruby.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import travel.diary.ruby.article.entity.ArticleEntity;

@RequestMapping
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

}
