package com.sha.sumcheck.controller;

import com.sha.sumcheck.model.Question;
import com.sha.sumcheck.model.QuestionPost;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SumControllerTest {

    @Autowired
    private SumController sumController;

    @Test
    void getQuestion() {
        assertThat(sumController).isNotNull();
        Question ques = sumController.getQuestion();
        assert(ques.getQuestion().equals("Please add the numbers "));
    }

    @Test
    void checkQuestions_with_success() {
        QuestionPost q = new QuestionPost();
        int[] val = {1,2,3};
        q.setNum(val);
        q.setAnswer(6);
        ResponseEntity res = sumController.checkQuestions(q);
        assert(res.getStatusCode() == HttpStatus.OK);

    }

    @Test
    void checkQuestions_with_bad_request() {
        QuestionPost q = new QuestionPost();
        int[] val = {1,2,3};
        q.setNum(val);
        q.setAnswer(63);
        ResponseEntity res = sumController.checkQuestions(q);
        assert(res.getStatusCode() == HttpStatus.BAD_REQUEST);

    }
}
