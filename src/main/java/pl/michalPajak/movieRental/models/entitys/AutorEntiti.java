package pl.michalPajak.movieRental.models.entitys;

import lombok.Data;
import pl.michalPajak.movieRental.models.enums.MovieType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "autor")
@Data
public class AutorEntiti {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String surname;
    private LocalDate birthday;

    @OneToMany(mappedBy = "autor")
    List<MovieEntiti> movies;
}
