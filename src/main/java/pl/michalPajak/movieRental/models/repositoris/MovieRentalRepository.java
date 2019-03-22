package pl.michalPajak.movieRental.models.repositoris;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.michalPajak.movieRental.models.entitis.MovieEntity;

@Repository
public interface MovieRentalRepository extends CrudRepository<MovieEntity, Integer> {

   // @Query(nativeQuery = true, value = "SELECT * FROM `movie` WHERE `title` = ?1")
//    boolean existsByTitle(String name);

    @Query(nativeQuery = true, value = "SELECT EXISTS(SELECT * FROM `movie` WHERE `title` = ?1)")
    int existsByTitle(String title);
}
