package com.ahea.nurikabe.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String getRightAnswer(String source) {
        return "[]";
    }
}
