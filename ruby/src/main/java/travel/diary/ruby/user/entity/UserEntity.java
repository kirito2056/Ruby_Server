package travel.diary.ruby.user.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "user_entity")
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long UserId;

    @Column(name = "email")
    private String email;

    @Column(nullable = false, name = "platform")
    @Enumerated(EnumType.STRING)
    private PlatformType platform;

    @Column(nullable = false, name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType user_type;
}