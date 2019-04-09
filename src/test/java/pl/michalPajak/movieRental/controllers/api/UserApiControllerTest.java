package pl.michalPajak.movieRental.controllers.api;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.michalPajak.movieRental.models.forms.UserForm;
import pl.michalPajak.movieRental.models.services.UserService;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class UserApiControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserApiController userApiController;

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldSaveUsers() throws Exception {
        UserForm userForm = new UserForm();
        userForm.setUserName("lolek");
        userForm.setPassword("bolek");
        userForm.setEmail("asdfgh@dfgh.pl");

        Mockito.when(userService.register(userForm)).thenReturn(true);

        mockMvc.perform(post("/api/user")
                .content(getGson().toJson(userForm))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldDeleteUsersByIdNotFound() throws Exception {
        int anyId = anyInt();

        Mockito.when(userService.deleteUserById(anyId)).thenReturn(false);

        mockMvc.perform(delete("/api/user/delete/" + anyId)
                .header("api-key", "adas8askfaidADYGDYAGD98753nwDNSAAUFHWQ9FDsaf"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldDeleteUsersByIdDelete() throws Exception {
        int anyId = anyInt();

        Mockito.when(userService.deleteUserById(anyId)).thenReturn(true);

        mockMvc.perform(delete("/api/user/delete/" + anyId))
                .andExpect(status().isOk());
    }

    public Gson getGson(){
        return new Gson();
    }
}