package com.galvanize.trivia.controllers;

import com.galvanize.trivia.entities.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class TriviaControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void getAllQuestions_ReturnsExpectedList() throws Exception {
        mockMvc.perform(get("/api/v1/questions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.length()").value(15))
                .andExpect(jsonPath("$.[0].answerList.length()").value(3))
                .andExpect(jsonPath("$.[1].answerList.length()").value(3));
    }

    @Test
    public void getSpecificNumberOfRandomQuestions() throws Exception {
        mockMvc.perform(get("/api/v1/questions/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(10));

        String firstRun = mockMvc.perform(get("/api/v1/questions/10"))
                .andReturn().getResponse().getContentAsString();

        String secondRun = mockMvc.perform(get("/api/v1/questions/10"))
                .andReturn().getResponse().getContentAsString();

        Assertions.assertNotEquals(firstRun, secondRun);
    }
}
