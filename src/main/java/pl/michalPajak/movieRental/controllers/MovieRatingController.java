package pl.michalPajak.movieRental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.michalPajak.movieRental.models.entitis.MovieEntity;
import pl.michalPajak.movieRental.models.repositoris.MovieRentalRepository;
import pl.michalPajak.movieRental.models.services.MovieRatingService;

import java.util.Optional;

@Controller
public class MovieRatingController {
    private static final String REDIRECT_MOVIE_LIST = "redirect:/";
    private static final String ADD_VOTE_UP_MOVIE = "/movie/vote/up/{movieId}";
    private static final String ADD_VOTE_DOWN_MOVIE = "/movie/vote/down/{movieId}";
    private static final String PATH_VAR_NAME_MOVIE_ID ="movieId";

    @Autowired
    MovieRatingService movieRatingService;
    @Autowired
    MovieRentalRepository movieRentalRepository;

    @PostMapping(ADD_VOTE_UP_MOVIE)
    public String addVoteUp(@PathVariable(PATH_VAR_NAME_MOVIE_ID) int movieId) {

        Optional<MovieEntity> optionalMovieEntity = movieRentalRepository.findById(movieId);
        if (optionalMovieEntity.isPresent())
            movieRatingService.addVoteUp(optionalMovieEntity.get());

        return REDIRECT_MOVIE_LIST;
    }

    @PostMapping(ADD_VOTE_DOWN_MOVIE)
    public String addVoteDown(@PathVariable(PATH_VAR_NAME_MOVIE_ID) int movieId) {

        Optional<MovieEntity> optionalMovieEntity = movieRentalRepository.findById(movieId);
        if (optionalMovieEntity.isPresent())
            movieRatingService.addVoteDown(optionalMovieEntity.get());

        return REDIRECT_MOVIE_LIST;
    }
}
