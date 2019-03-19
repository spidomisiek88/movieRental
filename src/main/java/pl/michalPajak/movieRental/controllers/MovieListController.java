package pl.michalPajak.movieRental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.michalPajak.movieRental.services.MovieListService;

@Controller
public class MovieListController {

    @Autowired
    MovieListService movieListService;

    @GetMapping("/")
    public String showMovieListView(Model model){

        model.addAttribute("movieList", movieListService.getAllMovies());

        return "movies_list_view";
    }
}
