package pl.michalPajak.movieRental.models.repositoris;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.michalPajak.movieRental.models.entitis.CommentEntity;

@Repository
public interface MovieRatingRepository extends CrudRepository<CommentEntity, Integer> {
}
