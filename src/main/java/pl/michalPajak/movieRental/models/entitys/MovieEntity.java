package pl.michalPajak.movieRental.models.entitys;

import lombok.Data;
import pl.michalPajak.movieRental.models.enums.MovieType;

import javax.persistence.*;

@Entity
@Table(name = "movie")
@Data
public class MovieEntyty {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String autor;
    @Column(name = "release_year")
    private int releaseYear;
    @Enumerated(EnumType.STRING)
    @Column(name = "movie_type")
    private MovieType movieType;
    @Column(name = "short_description")
    private String shortDescription;
    @Column(name = "long_description")
    private String longDescription;
}
