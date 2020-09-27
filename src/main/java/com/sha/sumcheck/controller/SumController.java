package com.sha.sumcheck.controller;

import com.sha.sumcheck.model.Question;
import com.sha.sumcheck.model.QuestionPost;
import com.sha.sumcheck.service.Questions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class SumController {

    private final Questions questions;

    public SumController(Questions questions) {
        this.questions = questions;
    }

    @GetMapping()
    public Question getQuestion(){
        return questions.getQuestion();
    }

    @PostMapping()
    public ResponseEntity checkQuestions(@RequestBody QuestionPost question){

        boolean checkAnswer = questions.checkAnswer(question.getAnswer(),question.getNum());
        if (checkAnswer)
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
