package pl.michalPajak.movieRental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.michalPajak.movieRental.models.forms.LoginForm;
import pl.michalPajak.movieRental.models.forms.UserForm;
import pl.michalPajak.movieRental.models.services.UserService;
import pl.michalPajak.movieRental.models.services.UserSession;

import javax.validation.Valid;

@Controller
public class AuthorizationController {
    private static final String URL_LOGIN_FORM = "/user/login";
    private static final String URL_REGISTER_FORM = "/user/register";
    private static final String LOGIN_FORM_TEMPLATE_NAME = "login_form";
    private static final String REDIRECT_LOGIN_FORM = "redirect:/user/login";
    private static final String REGISTER_FORM_TEMPLATE_NAME = "user_register_form";
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

        if (! userService.login(loginForm)) {
            model.addAttribute("loginInfo", "Login or password incorrect");
            return LOGIN_FORM_TEMPLATE_NAME;
        }

        return REDIRECT_MOVIE_LIST;
    }

    @GetMapping(URL_REGISTER_FORM)
    public String showRegistryForm(Model model) {

        model.addAttribute("userForm", new UserForm());

        return REGISTER_FORM_TEMPLATE_NAME;
    }

    @PostMapping(URL_REGISTER_FORM)
    public String register(@ModelAttribute UserForm userForm, Model model){
        if (userService.register(userForm)) {

            userService.login(new LoginForm(userForm.getUserName(), userForm.getPassword()));
            return REDIRECT_MOVIE_LIST;
        }

        return REDIRECT_LOGIN_FORM;
    }
}
