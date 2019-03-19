package pl.michalPajak.movieRental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.michalPajak.movieRental.models.services.MovieDescriptionService;

@Controller
public class MovieDescriptionController {

    @Autowired
    MovieDescriptionService movieDescriptionService;

    @GetMapping("/movie/description/{movieId}")
    public String showMovieDescriptionView(@PathVariable("movieId") int movieId, Model model) {

        model.addAttribute("movie", movieDescriptionService.getMovieById(movieId));

        return "movie_description_view";
    }
}
