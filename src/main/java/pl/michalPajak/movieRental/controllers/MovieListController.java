package pl.michalPajak.movieRental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.michalPajak.movieRental.models.services.MovieListService;

@Controller
public class MovieListController {

    private static final String URL_MOVIE_LIST = "/";
    private static final String MOVIE_LIST_TEMPLATE_NAME = "movies_list_view";
    private static final String MODEL_ATTRIB_NAME_MOVIE_LIST ="movieList";

    @Autowired
    MovieListService movieListService;

    @GetMapping(URL_MOVIE_LIST)
    public String showMovieListView(Model model){

        model.addAttribute(MODEL_ATTRIB_NAME_MOVIE_LIST, movieListService.getAllMovies());

        return MOVIE_LIST_TEMPLATE_NAME;
    }
}
