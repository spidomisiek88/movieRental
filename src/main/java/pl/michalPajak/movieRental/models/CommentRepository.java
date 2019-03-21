package pl.michalPajak.movieRental.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.michalPajak.movieRental.models.entitys.CommentEntiti;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntiti, Integer> {
}
