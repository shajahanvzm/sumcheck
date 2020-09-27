package com.sha.sumcheck.service;

import com.sha.sumcheck.model.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class QuestionsImpl implements Questions {

    @Value("${sum.array.size}")
    private int arraySize;

    @Value("${sum.upper.low}")
    private int low;

    @Value("${sum.upper.bound}")
    private int upperBound;

    @Override
    public Question getQuestion() {
        Question question = new Question();
        question.setQuestion("Please add the numbers ");
        int[] numbers = getNumbers();
        question.setNum(numbers);
        return question;
    }

    private int[] getNumbers() {
        Random rand = new Random();
        int size =rand.nextInt(arraySize - low )+low;
        int[] val = new int[size];
        for(int i=0;i<size;i++){
            val[i] = rand.nextInt(upperBound);
        }
        return val;
    }

    @Override
    public boolean checkAnswer(int answer, int... numbers) {
        int sum=0;
        for(int i=0;i<numbers.length;i++){
            sum = sum + numbers[i];
        }
        if(answer==sum)
            return true;
        else
            return false;
    }


}
