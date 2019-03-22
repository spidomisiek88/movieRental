package pl.michalPajak.movieRental.models.repositoris;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.michalPajak.movieRental.models.entitis.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM `user` WHERE `user_name` = ?1 AND `password` = ?2")
    Optional<UserEntity> findUserByLoginAndPassword(String login, String password);
}
