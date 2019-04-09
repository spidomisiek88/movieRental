package pl.michalPajak.movieRental.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.michalPajak.movieRental.models.entitis.UserEntity;
import pl.michalPajak.movieRental.models.forms.UserForm;
import pl.michalPajak.movieRental.models.services.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserApiController {

    final UserService userService;

    @Autowired
    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user", produces = "application/json")
    public ResponseEntity getUsers() {

        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping(value = "/user/{userId}", produces = "application/json")
    public ResponseEntity getUsersById(@PathVariable("userId") int userId) {

        Optional<UserEntity> optionalUserEntity = userService.getUserById(userId);
        if (!optionalUserEntity.isPresent())
            return ResponseEntity.notFound().build();

            return ResponseEntity.ok(optionalUserEntity.get());
    }


    @DeleteMapping(value = "/user/delete/{userId}", produces = "application/json")
    public ResponseEntity deleteUsersById(@PathVariable("userId") int userId) {

        if (!userService.deleteUserById(userId))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/user", consumes = "application/json")
    public ResponseEntity saveUsers(@RequestBody UserForm userForm) {
        if (!userService.register(userForm))
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("userName is taken");
        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }
}
