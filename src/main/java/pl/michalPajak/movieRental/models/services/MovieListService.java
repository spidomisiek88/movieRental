package pl.michalPajak.movieRental.services;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalPajak.movieRental.models.MovieForm;
import pl.michalPajak.movieRental.models.MovieRentalRepository;
import pl.michalPajak.movieRental.models.entitys.MovieEntity;
import pl.michalPajak.movieRental.models.enums.MovieType;

import java.util.List;

@Service
@Data
public class MovieListService {

    @Autowired
    private MovieRentalRepository movieRentalRepository;
    private MovieForm movieForm;
    private MovieEntity movie;

    public List<MovieEntity> getAllMovies() {
        return Lists.newArrayList(movieRentalRepository.findAll());
    }

    public void addNewMovie() {
        movie = new MovieEntity();
        movie.setName(movieForm.getName());
        movie.setAutor(movieForm.getAutor());
        movie.setReleaseYear(movieForm.getReleaseYear());
        movie.setMovieType(MovieType.valueOf(movieForm.getMovieType()));
        movie.setShortDescription(movieForm.getShortDescription());
        movie.setLongDescription(movieForm.getLongDescription());

        movieRentalRepository.save(movie);
    }
}
