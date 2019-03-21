package pl.michalPajak.movieRental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.michalPajak.movieRental.models.services.AutorListService;

@Controller
public class AutorController {

    private static final String URL_AUTOR_LIST = "/autor/list/";
    private static final String MOVIE_LIST_TEMPLATE_NAME = "autor_list_view";
    private static final String MODEL_ATTRIB_NAME_AUTOR_LIST ="autorList";

    @Autowired
    AutorListService autorListService;

    @GetMapping(URL_AUTOR_LIST)
    public String showAutorListView(Model model){

        model.addAttribute(MODEL_ATTRIB_NAME_AUTOR_LIST, autorListService.getAllAutors());

        return MOVIE_LIST_TEMPLATE_NAME;
    }
}
