package pl.michalPajak.movieRental.models.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.michalPajak.movieRental.models.repositoris.AutorRepository;
import pl.michalPajak.movieRental.models.repositoris.MovieRentalRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class MovieListServiceTest {

    @Mock
    AutorRepository autorRepository;
    @Mock
    MovieRentalRepository movieRentalRepository;

    @BeforeEach
    public void init() { MockitoAnnotations.initMocks(this);
    }

//    @Test
//    void getAllMovies() {
//    }
//
//    @Test
//    void getMovieById() {
//    }
//
//    @Test
//    void isExistMovie() {
//    }

    @Test
    void shoutlAddNewMovieThrow() {
    }
}