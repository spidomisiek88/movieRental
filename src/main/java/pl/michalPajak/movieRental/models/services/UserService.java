package pl.michalPajak.movieRental.models.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
//        Optional<UserEntity> optionalUserEntity = userRepository.findUserByLoginAndPassword(loginForm.getUserName(),
//                loginForm.getPassword());
        Optional<UserEntity> optionalUserEntity = userRepository.findUserByLogin(loginForm.getUserName());
        if (optionalUserEntity.isPresent() && getBCrypt().matches(loginForm.getPassword(), optionalUserEntity.get().getPassword())) {
            userSession.setLogin(true);
            userSession.setUserId(optionalUserEntity.get().getId());
            userSession.setAdmin(optionalUserEntity.get().isAdmin());
            return true;
        }
        return false;
    }

    public boolean register(UserForm userForm) {
        if (userRepository.isUserNameTaken(userForm.getUserName()))
            return false;

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userForm.getUserName());
        userEntity.setPassword(getBCrypt().encode(userForm.getPassword()));
        userEntity.setEmail(userForm.getEmail());

        userRepository.save(userEntity);
        return true;
    }

    public Iterable<UserEntity> getAll() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(int userId) {
        return userRepository.findUserById(userId);
    }

    @Transactional
    public boolean deleteUserById(int userId) {
        Optional<UserEntity> optionalUserEntity = getUserById(userId);
        if (optionalUserEntity.isPresent()) {
            userRepository.softDeleteUserById(userId);
            return getUserById(userId).get().isDelete();
        }

        return false;
    }

    @Bean
    public BCryptPasswordEncoder getBCrypt() {
        return new BCryptPasswordEncoder();
    }
}
