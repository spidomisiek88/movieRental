package pl.michalPajak.movieRental.models.entitis;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "autor")
@Data
public class AutorEntity {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String surname;
    private LocalDate birthday;

    @OneToMany(mappedBy = "autor")
    List<MovieEntity> movies;
}
