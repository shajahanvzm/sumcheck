package com.sha.sumcheck.service;

import com.sha.sumcheck.model.Question;

public interface Questions {

    Question getQuestion();
    boolean checkAnswer(int answer, int... numbers);


}
