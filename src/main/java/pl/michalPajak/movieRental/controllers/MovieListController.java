package pl.michalPajak.movieRental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.michalPajak.movieRental.models.MovieForm;
import pl.michalPajak.movieRental.services.MovieListService;

import javax.validation.Valid;

@Controller
public class MovirListController {

    @Autowired
    MovieListService movieListService;

    @GetMapping("/")
    public String showMovieListView(Model model){

        model.addAttribute("movieList", movieListService.getAllMovies());

        return "movies_list_view";
    }

    @PostMapping("/movie/add")
    public String addMovieToList(@ModelAttribute @Valid MovieForm movieForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // TODO: 2019-03-19
        }

        return "movie_form";
    }
}