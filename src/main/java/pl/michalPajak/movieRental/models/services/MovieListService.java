package pl.michalPajak.movieRental.models.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalPajak.movieRental.models.forms.MovieForm;
import pl.michalPajak.movieRental.models.repositoris.MovieRentalRepository;
import pl.michalPajak.movieRental.models.entitis.AutorEntity;
import pl.michalPajak.movieRental.models.entitis.MovieEntity;
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
    private MovieEntity movie;
    @Autowired
    private AutorListService autorListService;

    public Iterable<MovieEntity> getAllMovies() {
        return movieRentalRepository.findAll();
    }

    public MovieEntity getMovieById(int movieId) {
        Optional<MovieEntity> optionalMovieEntiti = movieRentalRepository.findById(movieId);
        if (optionalMovieEntiti.isPresent())
            return optionalMovieEntiti.get();
        throw new IllegalStateException();
    }

//    public boolean isExistMovie(String name) {
//        //return movieRentalRepository.isExistMovieByName(name);
//        return movieRentalRepository.existsByTitle(name);
//    }

    public boolean isExistMovie(String name) {
    return movieRentalRepository.existsByTitle(name) > 0 ? true : false;
}

//    @Transactional
    public MovieResponse addNewMovie(MovieForm movieForm) {
        AutorEntity newAutorEntity = autorListService.getAutorByName(movieForm.getAutor());

        if (newAutorEntity == null)
            return MovieResponse.AUTOR_NOT_EXIST;

        if (isExistMovie(movieForm.getName()))
            return MovieResponse.TITLE_ALREDY_EXIST;

        movie = new MovieEntity();
        movie.setTitle(movieForm.getName());
        movie.setAutor(newAutorEntity);
        movie.setReleaseYear(movieForm.getReleaseYear());
        movie.setMovieType(MovieType.valueOf(movieForm.getMovieType()));
        movie.setShortDescription(movieForm.getShortDescription());
        movie.setLongDescription(movieForm.getLongDescription());

        movieRentalRepository.save(movie);

        return MovieResponse.CREATED;
    }
}
