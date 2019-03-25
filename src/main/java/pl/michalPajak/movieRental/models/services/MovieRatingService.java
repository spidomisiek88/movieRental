package pl.michalPajak.movieRental.models.services;

import lombok.Data;
import org.springframework.stereotype.Service;
import pl.michalPajak.movieRental.models.entitis.MovieEntity;

@Service
@Data
public class MovieRatingService {

    public void addVoteUp(MovieEntity movieEntity) {
        movieEntity.getMovieRating().setVoteUp(movieEntity.getMovieRating().getVoteUp() + 1);
    }

    public void addVoteDown(MovieEntity movieEntity) {
        movieEntity.getMovieRating().setVoteDown(movieEntity.getMovieRating().getVoteDown() + 1);
    }
}
