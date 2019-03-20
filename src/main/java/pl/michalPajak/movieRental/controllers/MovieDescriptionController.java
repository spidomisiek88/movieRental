package pl.michalPajak.movieRental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.michalPajak.movieRental.models.services.MovieDescriptionService;

@Controller
public class MovieDescriptionController {

    private static final String URL_MOVIE_DECRIPTION = "/movie/description/{movieId}";
    private static final String MOVIE_DECRIPTION_TEMPLATE_NAME = "movie_description_view";
    private static final String PATH_VAR_NAME_MOVIE_ID ="movieId";
    private static final String MODEL_ATTRIB_NAME_MOVIE_ID ="movie";

            @Autowired
    MovieDescriptionService movieDescriptionService;

    @GetMapping(URL_MOVIE_DECRIPTION)
    public String showMovieDescriptionView(@PathVariable(PATH_VAR_NAME_MOVIE_ID) int movieId, Model model) {

        model.addAttribute(MODEL_ATTRIB_NAME_MOVIE_ID, movieDescriptionService.getMovieById(movieId));

        return MOVIE_DECRIPTION_TEMPLATE_NAME;
    }
}
