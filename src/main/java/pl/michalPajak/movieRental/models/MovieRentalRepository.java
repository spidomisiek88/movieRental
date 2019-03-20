package pl.michalPajak.movieRental.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.michalPajak.movieRental.models.entitys.MovieEntity;

@Repository
public interface MovieRentalRepository extends CrudRepository<MovieEntity, Integer> {
}
