package pl.michalPajak.movieRental.models.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalPajak.movieRental.models.entitis.UserEntity;
import pl.michalPajak.movieRental.models.forms.LoginForm;
import pl.michalPajak.movieRental.models.forms.UserForm;
import pl.michalPajak.movieRental.models.repositoris.UserRepository;

import java.util.Optional;

@Service
@Data
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserSession userSession;

    public boolean login(LoginForm loginForm){
        Optional<UserEntity> optionalUserEntity = userRepository.findUserByLoginAndPassword(loginForm.getUserName(),
                loginForm.getPassword());
        if (optionalUserEntity.isPresent()) {
            userSession.setLogin(true);
            userSession.setUserId(optionalUserEntity.get().getId());
            return true;
        }
        return false;
    }

    public boolean isUserNameTaken(UserForm userForm) {
        return userRepository.isUserNameTaken(userForm.getUserName());
    }

    public boolean register(UserForm userForm) {
        if (userRepository.isUserNameTaken(userForm.getUserName()))
            return false;

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userForm.getUserName());
        userEntity.setPassword(userForm.getPassword());
        userEntity.setEmail(userForm.getEmail());

        userRepository.save(userEntity);
        return true;
    }
}
