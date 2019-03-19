package pl.michalPajak.movieRental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalPajak.movieRental.models.MovieRentalRepository;
import pl.michalPajak.movieRental.models.entitys.MovieEntity;

@Service
public class MovieDescriptionService {

    @Autowired
    MovieRentalRepository movieRentalRepository;

    public MovieEntity getMovieById(int movieId){
        return movieRentalRepository.findMovieById(movieId);
    }
}
