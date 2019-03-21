package pl.michalPajak.movieRental.models.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalPajak.movieRental.models.MovieForm;
import pl.michalPajak.movieRental.models.MovieRentalRepository;
import pl.michalPajak.movieRental.models.entitys.AutorEntiti;
import pl.michalPajak.movieRental.models.entitys.MovieEntiti;
import pl.michalPajak.movieRental.models.enums.MovieType;

import java.util.Optional;

@Service
@Data
public class MovieListService {

    public enum MovieResponse {
        CREATED, AUTOR_NOT_EXIST, TITLE_ALREDY_EXIST;
    }

    @Autowired
    private MovieRentalRepository movieRentalRepository;
    private MovieEntiti movie;
    @Autowired
    private AutorListService autorListService;

    public Iterable<MovieEntiti> getAllMovies() {
        return movieRentalRepository.findAll();
    }

    public MovieEntiti getMovieById(int movieId) {
        Optional<MovieEntiti> optionalMovieEntiti = movieRentalRepository.findById(movieId);
        if (optionalMovieEntiti.isPresent())
            return optionalMovieEntiti.get();
        throw new IllegalStateException();
    }

    public boolean isExistMovie(String name) {
        return movieRentalRepository.isExistMovieByName(name).booleanValue();
    }

    public MovieResponse addNewMovie(MovieForm movieForm) {
        AutorEntiti newAutorEntiti = autorListService.getAutorByName(movieForm.getAutor());

        if (newAutorEntiti == null)
            return MovieResponse.AUTOR_NOT_EXIST;

        if (!isExistMovie(movieForm.getName()))
            return MovieResponse.TITLE_ALREDY_EXIST;

        movie = new MovieEntiti();
        movie.setName(movieForm.getName());
        movie.setAutor(newAutorEntiti);
        movie.setReleaseYear(movieForm.getReleaseYear());
        movie.setMovieType(MovieType.valueOf(movieForm.getMovieType()));
        movie.setShortDescription(movieForm.getShortDescription());
        movie.setLongDescription(movieForm.getLongDescription());

        movieRentalRepository.save(movie);

        return MovieResponse.CREATED;
    }
}
