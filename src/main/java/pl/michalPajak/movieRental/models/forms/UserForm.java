package pl.michalPajak.movieRental.models.forms;

import lombok.Data;

@Data
public class UserForm {

    private String userName;
    private String password;
    private String email;
}
