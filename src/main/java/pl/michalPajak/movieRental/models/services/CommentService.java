package pl.michalPajak.movieRental.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalPajak.movieRental.models.entitis.UserEntity;
import pl.michalPajak.movieRental.models.repositoris.CommentRepository;
import pl.michalPajak.movieRental.models.entitis.CommentEntity;
import pl.michalPajak.movieRental.models.entitis.MovieEntity;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserSession userSession;

    public void addComment(int movieId, String comment){
        MovieEntity movieEntiti = new MovieEntity();
        movieEntiti.setId(movieId);

        UserEntity userEntity = new UserEntity();
        userEntity.setId(userSession.getUserId());

        CommentEntity commentEntiti = new CommentEntity();
        commentEntiti.setCommentContent(comment);
        commentEntiti.setMovie(movieEntiti);
        commentEntiti.setUser(userEntity);

        commentRepository.save(commentEntiti);
    }
}
