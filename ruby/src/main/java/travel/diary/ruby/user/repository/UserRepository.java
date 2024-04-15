package travel.diary.ruby.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import travel.diary.ruby.user.entity.UserEntity;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT a FROM UserEntity a")
    List<UserEntity> findAllUsers();


    @Query("SELECT a FROM UserEntity a where a.email =:email")
    UserEntity findByEmail(@Param("email") String email);
}
