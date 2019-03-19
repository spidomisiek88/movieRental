package pl.michalPajak.movieRental.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.michalPajak.movieRental.models.entitys.MovieEntyty;

import java.util.List;

@Repository
public interface MovieRentalRepository {

    @Query(nativeQuery = true, value = "SELECT * FROM `movie`")
    List<MovieEntyty> findAllMovies();
}
