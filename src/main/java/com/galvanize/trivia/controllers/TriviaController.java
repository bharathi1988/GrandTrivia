package com.galvanize.trivia.controllers;

import com.galvanize.trivia.entities.Question;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "Trivia" )
public class TriviaController {
    @GetMapping("/api/v1/questions")
    public List<Question> getAllQuestions() {
        return new ArrayList<>();
    }
}
