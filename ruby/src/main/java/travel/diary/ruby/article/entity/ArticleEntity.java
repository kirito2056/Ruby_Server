package travel.diary.ruby.article.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Table(name = "diary")
@Entity
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long articleId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "written_date")
    private Timestamp writtenDate;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private ArticleCategory category;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lon")
    private Double lon;

    @Column(name = "city")
    private String city;
}
