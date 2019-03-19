package pl.michalPajak.movieRental.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.michalPajak.movieRental.models.entitys.MovieEntity;

@Repository
public interface MovieRentalRepository extends CrudRepository<MovieEntity, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM `movie` WHERE id = ?1")
    MovieEntity findMovieById(int movieId);
}
