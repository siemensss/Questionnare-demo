package com.example.questionnairedemo.service.impl;

import com.example.questionnairedemo.model.Question;
import com.example.questionnairedemo.service.QuestionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;


public class JavaQuestionServiceTest {
    private final QuestionService questionService = new JavaQuestionService();
   @BeforeEach
   public void beforeEach (){
       questionService.add("Q1", "A1");
       questionService.add("Q2", "A2");
       questionService.add("Q3", "A3");
   }
    @AfterEach
    public void afterEach() {
      new HashSet<>(questionService.getAll()).forEach(questionService::remove);

    }
    @Test
    public void add1Test (){
        int beforeCount = questionService.getAll().size();
        Question question = new Question("Q4", "A4");
        assertThat(questionService.add(question))
                .isEqualTo(question)
                .isIn(questionService.getAll());
        assertThat(questionService.getAll()).hasSize(beforeCount + 1);
    }
    @Test
    public void add2Test (){
        int beforeCount = questionService.getAll().size();
        Question question = new Question("Q4", "A4");
        assertThat(questionService.add("Q4", "A4"))
                .isEqualTo(question)
                .isIn(questionService.getAll());
        assertThat(questionService.getAll()).hasSize(beforeCount + 1);
    }
    @Test
    public void removeTest (){
        int beforeCount = questionService.getAll().size();
        Question question = new Question("Q2", "A2");
        assertThat(questionService.remove(question))
                .isEqualTo(question)
                .isNotIn(questionService.getAll());
        assertThat(questionService.getAll()).hasSize(beforeCount - 1);
    }
    @Test
    public void getAllTest (){

        assertThat(questionService.getAll())
                .containsExactlyInAnyOrder(
                        new Question("Q1", "A1"),
                        new Question("Q2", "A2"),
                        new Question("Q3", "A3")
                ).hasSize(3);

    }
    @Test
    public void getRandomQuestionTest (){
        assertThat(questionService.getRandomQuestion())
                .isNotNull()
                .isIn(questionService.getAll());

    }

}
