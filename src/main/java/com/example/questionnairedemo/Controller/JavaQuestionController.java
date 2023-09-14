package com.example.questionnairedemo.Controller;

import com.example.questionnairedemo.model.Question;
import com.example.questionnairedemo.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequestMapping("/java")
@RestController
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping("/add")
    public Question addQuestion (@RequestParam String question,@RequestParam String answer) {
        return questionService.add(question, answer);

    }
    @GetMapping
    public Collection<Question> getQuestions () {
        return questionService.getAll();

    } @GetMapping("/remove")
    public Question removeQuestion (@RequestParam String question,@RequestParam String answer) {
        return questionService.remove(new Question (question, answer));

    }
}
