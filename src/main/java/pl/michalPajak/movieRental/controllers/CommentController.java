package pl.michalPajak.movieRental.controllers;

import com.oracle.jrockit.jfr.ValueDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.michalPajak.movieRental.models.services.CommentService;
import pl.michalPajak.movieRental.models.services.MovieListService;
import pl.michalPajak.movieRental.models.services.UserSession;

@Controller
public class CommentController {
    private static final String URL_MOVIE_COMMENT = "/movie/comment/{movieId}";
    private static final String URL_ADD_MOVIE_COMMENT = "/movie/comment/add/{movieId}";
    private static final String PATH_VAR_NAME_MOVIE_ID = "movieId";
    private static final String REDIRECT_LOGIN_FORM = "redirect:/user/login";
    private static final String MODEL_ATTRIB_NAME_COMMENT_LIST = "commentList";
    private static final String REQUEST_PARAM_NAME_COMMENT = "comment";
    private static final String COMMENT_TEMPLATE_NAME = "comments_list_view";
    private static final String REDIRECT_MOVIE_COMMENT = "redirect:/movie/comment/";

    @Autowired
    private MovieListService movieListService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserSession userSession;

    @GetMapping(URL_MOVIE_COMMENT)
    public String showMovieDescriptionView(@PathVariable(PATH_VAR_NAME_MOVIE_ID) int movieId, Model model) {

        model.addAttribute(MODEL_ATTRIB_NAME_COMMENT_LIST, movieListService.getMovieById(movieId).getCommentList());

        return COMMENT_TEMPLATE_NAME;
    }

    @PostMapping(URL_ADD_MOVIE_COMMENT)
    public String addCommentForm(@PathVariable(PATH_VAR_NAME_MOVIE_ID) int movieId, @RequestParam(REQUEST_PARAM_NAME_COMMENT) String comment) {

        if (!userSession.isLogin())
           return REDIRECT_LOGIN_FORM;

        commentService.addComment(movieId, comment);
        return REDIRECT_MOVIE_COMMENT + movieId;
    }
}
