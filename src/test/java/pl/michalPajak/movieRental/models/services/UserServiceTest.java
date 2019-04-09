package pl.michalPajak.movieRental.models.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.michalPajak.movieRental.models.entitis.UserEntity;
import pl.michalPajak.movieRental.models.forms.LoginForm;
import pl.michalPajak.movieRental.models.forms.UserForm;
import pl.michalPajak.movieRental.models.repositoris.UserRepository;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class UserServiceTest {

    @Mock
    UserRepository userRepository;
    @Mock
    UserSession userSession;
    @InjectMocks
    UserService userService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldLogin() {
        String testPasswordHash = "$2a$10$MIP.ao2o9M0HeCJN.OEXeOVlbI6vkBJccfPREuQdoNA2aKGcImB9m";
        LoginForm loginForm = new LoginForm();
        loginForm.setUserName("lolek");
        loginForm.setPassword("qwerty");

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(loginForm.getUserName());
        userEntity.setPassword(testPasswordHash);

        Mockito.when(userRepository.findUserByLogin("lolek")).thenReturn(Optional.of(userEntity));

        Assertions.assertTrue(userService.login(loginForm));
    }

    @Test
    public void shouldNotRegistryAlredyUserTagen() {

        UserForm userForm = new UserForm();
        userForm.setUserName("michal");
        userForm.setPassword("qwerty");
        userForm.setEmail("michal.pajak88@gmail.com");

        Mockito.when(userRepository.isUserNameTaken("michal")).thenReturn(true);

        Assertions.assertFalse(userService.register(userForm));
    }
}