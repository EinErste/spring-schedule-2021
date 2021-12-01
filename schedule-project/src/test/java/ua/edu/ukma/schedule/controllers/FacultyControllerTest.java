package ua.edu.ukma.schedule.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ua.edu.ukma.schedule.config.WebSecurityConfig;
import ua.edu.ukma.schedule.model.Faculty;
import ua.edu.ukma.schedule.services.FacultyService;
import ua.edu.ukma.schedule.services.impl.UserServiceImpl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EnableAutoConfiguration(exclude = {WebSecurityConfig.class})
@WebMvcTest(controllers = FacultyController.class)
class FacultyControllerTest {

    public static final String TEST_USER_EMAIL = "olegvynnyk@gmail.com";
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private FacultyService facultyService;

    @MockBean
    private UserServiceImpl userService;

    @WithAnonymousUser
    @Test
    void whenAnonymousGetRequestSuccess() throws Exception {
        mockMvc.perform(get("/api/faculty/1")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @WithAnonymousUser
    @Test
    void whenAnonymousPostRequestRedirect() throws Exception {
        Faculty faculty = Faculty.builder().name("").fullName("").build();
        mockMvc.perform(post("/api/faculty/")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(faculty)))
                .andExpect(status().is3xxRedirection());
    }

    @WithMockUser(value = TEST_USER_EMAIL, authorities = "METHODIST")
    @Test
    void whenLoggedInPostRequestSuccess() throws Exception {
        Faculty faculty = Faculty.builder().name("FI").fullName("Faculty of Informatics").build();
        mockMvc.perform(post("/api/faculty/")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(faculty)))
                .andExpect(status().isOk());
    }

}