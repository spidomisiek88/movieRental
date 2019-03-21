package pl.michalPajak.movieRental.models.entitys;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comment")
@Data
public class CommentEntiti {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieEntiti movie;
    @Column(name = "date")
    private LocalDate dateComment;
    @Column(name = "comment_content")
    private String commentContent;
}
