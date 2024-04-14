package travel.diary.ruby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"travel.diary.ruby"})
@EnableJpaRepositories({"travel.diary.ruby.article.repository", "travel.diary.ruby.user.repository"})
public class RubyApplication {
	public static void main(String[] args) {
		SpringApplication.run(RubyApplication.class, args);
	}

}
