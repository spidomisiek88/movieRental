package pl.michalPajak.movieRental.models.entitis;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comment")
@Data
public class CommentEntity {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @Column(name = "date")
    private LocalDate dateComment;
    @Column(name = "comment_content")
    private String commentContent;
}
