package travel.diary.ruby.user.entity.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UserSignupDTO {
    private String username;
    private String password;
    private String email;
}
