package pl.michalPajak.movieRental.models.entitis;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "movie_rating")
@Data
public class MovieRatingEntity {

    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;
    @Column(name = "vote_up")
    private int voteUp;
    @Column(name = "vote_down")
    private int voteDown;
}
