package com.galvanize.trivia.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriviaController {
    @GetMapping("/api/v1/questions")
    public void getAllQuestions() {

    }
}
