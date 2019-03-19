package pl.michalPajak.movieRental.services;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalPajak.movieRental.models.MovieRentalRepository;
import pl.michalPajak.movieRental.models.entitys.MovieEntity;

import java.util.List;

@Service
@Data
public class MovieListService {

    @Autowired
    private MovieRentalRepository movieRentalRepository;

    public List<MovieEntity> getAllMovies() {
        return Lists.newArrayList(movieRentalRepository.findAll());
    }
}
