package pl.michalPajak.movieRental.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalPajak.movieRental.models.MovieRentalRepository;
import pl.michalPajak.movieRental.models.entitys.MovieEntiti;

import java.util.Optional;

@Service
public class MovieDescriptionService {

    @Autowired
    MovieRentalRepository movieRentalRepository;

    public MovieEntiti getMovieById(int movieId){
        Optional<MovieEntiti> optionalMovieEntity = movieRentalRepository.findById(movieId);
        if (optionalMovieEntity.isPresent())
            return optionalMovieEntity.get();
        throw new IllegalStateException();
    }
}
