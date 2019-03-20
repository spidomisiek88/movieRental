package pl.michalPajak.movieRental.models.services;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalPajak.movieRental.models.MovieForm;
import pl.michalPajak.movieRental.models.MovieRentalRepository;
import pl.michalPajak.movieRental.models.entitys.AutorEntiti;
import pl.michalPajak.movieRental.models.entitys.MovieEntiti;
import pl.michalPajak.movieRental.models.enums.MovieType;

import java.util.List;

@Service
@Data
public class MovieListService {

    @Autowired
    private MovieRentalRepository movieRentalRepository;
    private MovieEntiti movie;

    public List<MovieEntiti> getAllMovies() {
        return Lists.newArrayList(movieRentalRepository.findAll());
    }

    public void addNewMovie(MovieForm movieForm) {
        AutorEntiti autorEntiti = new AutorEntiti();
        autorEntiti.setId(1);//TODO

        movie = new MovieEntiti();
        movie.setName(movieForm.getName());
        movie.setAutor(autorEntiti);
        movie.setReleaseYear(movieForm.getReleaseYear());
        movie.setMovieType(MovieType.valueOf(movieForm.getMovieType()));
        movie.setShortDescription(movieForm.getShortDescription());
        movie.setLongDescription(movieForm.getLongDescription());

        movieRentalRepository.save(movie);
    }
}
