package pl.michalPajak.movieRental.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalPajak.movieRental.models.repositoris.CommentRepository;
import pl.michalPajak.movieRental.models.entitis.CommentEntity;
import pl.michalPajak.movieRental.models.entitis.MovieEntity;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public void addComment(int movieId, String comment){
        MovieEntity movieEntiti = new MovieEntity();
        movieEntiti.setId(movieId);

        CommentEntity commentEntiti = new CommentEntity();
        commentEntiti.setCommentContent(comment);
        commentEntiti.setMovie(movieEntiti);

        commentRepository.save(commentEntiti);
    }
}
