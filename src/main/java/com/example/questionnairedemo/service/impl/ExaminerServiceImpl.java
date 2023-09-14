package com.example.questionnairedemo.service.impl;

import com.example.questionnairedemo.exceptions.IncorrectAmountOfQuestions;
import com.example.questionnairedemo.model.Question;
import com.example.questionnairedemo.service.ExaminerService;
import com.example.questionnairedemo.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if(amount <= 0 || questionService.getAll().size() < amount){
            throw new IncorrectAmountOfQuestions();
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount){
            questionService.getRandomQuestion();
        }

        return result;
    }

}
