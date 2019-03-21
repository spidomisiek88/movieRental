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

@Controller
public class CommentController {
    private static final String URL_MOVIE_COMMENT = "/movie/comment/{movieId}";
    private static final String PATH_VAR_NAME_MOVIE_ID = "movieId";
    private static final String MODEL_ATTRIB_NAME_COMMENT_LIST = "commentList";
    private static final String COMMENT_TEMPLATE_NAME = "comments_list_view";

    @Autowired
    private MovieListService movieListService;
    @Autowired
    private CommentService commentService;

    @GetMapping(URL_MOVIE_COMMENT)
    public String showMovieDescriptionView(@PathVariable(PATH_VAR_NAME_MOVIE_ID) int movieId, Model model) {

        model.addAttribute(MODEL_ATTRIB_NAME_COMMENT_LIST, movieListService.getMovieById(movieId).getCommentList());

        return COMMENT_TEMPLATE_NAME;
    }

    @PostMapping("/movie/comment/add/{movieId}")
    public String addCommentForm(@PathVariable("movieId") int movieId, @RequestParam("comment") String comment) {

        commentService.addComment(movieId, comment);

        return "redirect:/movie/comment/" + movieId;
    }
}
