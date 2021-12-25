package com.example.junitstudy.component;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    private ICalculator iCalculator;

    public Calculator(ICalculator iCalculator) {
        this.iCalculator = iCalculator;
    }

    public int sum(int x, int y) {
        this.iCalculator.init();
        return this.iCalculator.sum(x, y);
    }

    public int minus(int x, int y) {
        this.iCalculator.init();
        return this.iCalculator.minus(x, y);
    }

}
