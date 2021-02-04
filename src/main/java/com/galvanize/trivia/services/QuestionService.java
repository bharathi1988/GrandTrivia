package com.galvanize.trivia.services;

import com.galvanize.trivia.entities.Question;
import com.galvanize.trivia.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    public List<Question> getAllQuestions() {
        return questionRepository.findAll();

    }
}
