package travel.diary.ruby.article.entity;

import lombok.Data;

@Data
public class ArticleRequestDTO {
    private String title;
    private String content;
    private Double lat;
    private Double lon;
}
