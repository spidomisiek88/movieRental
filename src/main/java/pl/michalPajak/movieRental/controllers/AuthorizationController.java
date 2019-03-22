package pl.michalPajak.movieRental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.michalPajak.movieRental.models.forms.LoginForm;
import pl.michalPajak.movieRental.models.services.UserService;

import javax.validation.Valid;

@Controller
public class AuthorizationController {
    private static final String URL_LOGIN_FORM = "/user/login";
    private static final String LOGIN_FORM_TEMPLATE_NAME = "login_form";
    private static final String REDIRECT_MOVIE_LIST = "redirect:/";

    @Autowired
    UserService userService;

    @GetMapping(URL_LOGIN_FORM)
    public String showLoginForm(Model model) {

        model.addAttribute("loginForm", new LoginForm());

        return LOGIN_FORM_TEMPLATE_NAME;
    }

    @PostMapping(URL_LOGIN_FORM)
    public String login(@ModelAttribute @Valid LoginForm loginForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            //TODO
        }

        if (!userService.login(loginForm)) {
            model.addAttribute("loginInfo", "Login or password incorrect");
            return LOGIN_FORM_TEMPLATE_NAME;
        }

        return REDIRECT_MOVIE_LIST;
    }
}
