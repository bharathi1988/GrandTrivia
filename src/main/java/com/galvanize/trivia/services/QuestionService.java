package com.galvanize.trivia.services;

import com.galvanize.trivia.entities.Question;
import com.galvanize.trivia.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    public List<Question> getAllQuestions() {
        return questionRepository.findAll();

    }

    public List<Question> getRandomQuestions(int count) {
        Random random = new Random();

        List<Question> questions = questionRepository.findAll();
        Collections.shuffle(questions, new Random(random.nextInt()));

        return questions.stream().limit(count).collect(Collectors.toList());
    }
}
