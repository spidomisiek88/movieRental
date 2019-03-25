package pl.michalPajak.movieRental.models.forms;

import lombok.Data;

@Data
public class LoginForm {

    private String userName;
    private String password;

    public LoginForm() {

        this.userName = null;
        this.password = null;
    }

    public LoginForm(String userName, String password) {

        this.userName = userName;
        this.password = password;
    }
}
