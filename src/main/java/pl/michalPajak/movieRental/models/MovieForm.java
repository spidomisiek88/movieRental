package pl.michalPajak.movieRental.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.michalPajak.movieRental.models.enums.MovieType;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class MovieForm {

    private String name;
    private String autor;
    @Max(3000)
    @Min(0)
    @DateTimeFormat(pattern = "yyyy")
    private int releaseYear;
    private String movieType;
    private String shortDescription;
    private String longDescription;
}
