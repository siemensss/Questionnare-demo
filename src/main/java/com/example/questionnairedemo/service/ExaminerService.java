package com.example.questionnairedemo.service;

import com.example.questionnairedemo.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
