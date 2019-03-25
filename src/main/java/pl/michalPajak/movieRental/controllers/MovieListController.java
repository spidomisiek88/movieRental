package pl.michalPajak.movieRental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.michalPajak.movieRental.models.services.MovieListService;
import pl.michalPajak.movieRental.models.services.UserSession;

@Controller
public class MovieListController {

    private static final String URL_MOVIE_LIST = "/";
    private static final String MOVIE_LIST_TEMPLATE_NAME = "movies_list_view";
    private static final String MODEL_ATRIB_NAME_MOVIE_LIST = "movieList";
    private static final String MODEL_ATRIB_USER_SESSION_NAME = "userSession";

    @Autowired
    MovieListService movieListService;
    @Autowired
    UserSession userSession;

    @GetMapping(URL_MOVIE_LIST)
    public String showMovieListView(Model model){

        model.addAttribute(MODEL_ATRIB_NAME_MOVIE_LIST, movieListService.getAllMovies());
        model.addAttribute(MODEL_ATRIB_USER_SESSION_NAME, userSession);

        return MOVIE_LIST_TEMPLATE_NAME;
    }
}
