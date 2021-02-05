package com.galvanize.trivia.controllers;

import com.galvanize.trivia.entities.Question;
import com.galvanize.trivia.services.QuestionService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "Trivia" )
public class TriviaController {

    private QuestionService questionService;

    public TriviaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/api/v1/questions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/api/v1/questions/{count}")
    public List<Question> getRandomQuestions(@PathVariable int count) {
        return questionService.getRandomQuestions(count);
    }
}
