package pl.michalPajak.movieRental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.michalPajak.movieRental.models.MovieForm;
import pl.michalPajak.movieRental.models.services.MovieListService;

import javax.validation.Valid;

@Controller
public class MovieFormController {

    private static final String URL_MOVIE_FORM = "/movie/add";
    private static final String MOVIE_FORM_TEMPLATE_NAME = "movie_form";
    private static final String REDIRECT_MOVIE_FORM_TEMPLATE ="redirect:/movie/add";
    private static final String MODEL_ATTRIB_NAME_MOVIE_FORM ="movieForm";

    @Autowired
    MovieListService movieListService;

    @GetMapping(URL_MOVIE_FORM)
    public String showAddMovieForm(Model model){

        model.addAttribute(MODEL_ATTRIB_NAME_MOVIE_FORM, new MovieForm());

        return MOVIE_FORM_TEMPLATE_NAME;
    }

    @PostMapping(URL_MOVIE_FORM)
    public String addMovieToList(@ModelAttribute @Valid MovieForm movieForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // TODO: 2019-03-19
        }

        movieListService.addNewMovie(movieForm);

        return REDIRECT_MOVIE_FORM_TEMPLATE;
    }
}
