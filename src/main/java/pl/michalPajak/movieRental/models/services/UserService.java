package pl.michalPajak.movieRental.models.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalPajak.movieRental.models.entitis.UserEntity;
import pl.michalPajak.movieRental.models.forms.LoginForm;
import pl.michalPajak.movieRental.models.repositoris.UserRepository;

import java.util.Optional;

@Service
@Data
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean login(LoginForm loginForm){
        Optional<UserEntity> optionalUserEntity = userRepository.findUserByLoginAndPassword(loginForm.getUserName(),
                loginForm.getPassword());
        return optionalUserEntity.isPresent();
    }
}
