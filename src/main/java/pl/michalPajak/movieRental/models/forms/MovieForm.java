package pl.michalPajak.movieRental.models.forms;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
