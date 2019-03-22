package pl.michalPajak.movieRental.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.michalPajak.movieRental.models.entitis.AutorEntity;

import java.util.Optional;

@Repository
public interface AutorRepository extends CrudRepository<AutorEntity, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM `autor` WHERE surname = ?1")
    Optional<AutorEntity> findAurorBySurname(String surname);
}
