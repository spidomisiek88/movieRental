package pl.michalPajak.movieRental.models.repositoris;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.michalPajak.movieRental.models.entitis.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM `user` WHERE `user_name` = ?1 AND `password` = ?2")
    Optional<UserEntity> findUserByLoginAndPassword(String login, String password);

    @Query(nativeQuery = true, value = "SELECT CASE WHEN COUNT(`id`) > 0 THEN 'true' ELSE 'false' END FROM `user` WHERE user_name = ?1")
    boolean isUserNameTaken(String userName);

    @Query(nativeQuery = true, value = "SELECT * FROM `user` WHERE `user_name` = ?1")
    Optional<UserEntity> findUserByLogin(String login);

    @Query(nativeQuery = true, value = "SELECT * FROM `user` WHERE `id` = ?1")
    Optional<UserEntity> findUserById(int userId);

    @Query(nativeQuery = true, value = "UPDATE `user` SET `is_delete` = 1 WHERE `id` = ?1")
    @Modifying
    void softDeleteUserById(int userId);
}
