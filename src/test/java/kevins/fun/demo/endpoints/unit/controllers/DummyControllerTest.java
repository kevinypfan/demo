package kevins.fun.demo.endpoints.unit.controllers;

import kevins.fun.demo.controller.DummyController;
import kevins.fun.demo.controller.UserController;
import kevins.fun.demo.endpoints.unit.util.JsonUtil;
import kevins.fun.demo.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DummyController.class)
class DummyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should Receive String 'World' When making GET request to endpoint - /dummy/hello")
    public void createUser_whenPostMethod() throws Exception {


        mockMvc.perform(MockMvcRequestBuilders.get("/dummy/hello")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.hello", is("world")));
    }
}
