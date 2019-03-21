package pl.michalPajak.movieRental.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalPajak.movieRental.models.CommentRepository;
import pl.michalPajak.movieRental.models.entitys.CommentEntiti;
import pl.michalPajak.movieRental.models.entitys.MovieEntiti;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public void addComment(int movieId, String comment){
        MovieEntiti movieEntiti = new MovieEntiti();
        movieEntiti.setId(movieId);

        CommentEntiti commentEntiti = new CommentEntiti();
        commentEntiti.setCommentContent(comment);
        commentEntiti.setMovie(movieEntiti);

        commentRepository.save(commentEntiti);
    }
}
