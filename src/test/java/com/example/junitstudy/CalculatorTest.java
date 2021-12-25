package com.example.junitstudy;

import com.example.junitstudy.component.Calculator;
import com.example.junitstudy.component.DollarCalculator;
import com.example.junitstudy.component.MarketApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class CalculatorTest {

    @Mock
    private MarketApi marketApi;

    @BeforeEach
    public void init() {
        // connect를 호출할 때 3,000 반환 설정
        Mockito.lenient().when(marketApi.connect()).thenReturn(3_000);
    }

    @Test
    public void testHello() {
        System.out.println("Hello");
    }

    @Test
    public void dollarTest() {
        MarketApi marketApi = new MarketApi();
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();

        Calculator calculator = new Calculator(dollarCalculator);
        Assertions.assertEquals(22_000, calculator.sum(10, 10));
        Assertions.assertEquals(0, calculator.minus(10, 10));
    }

    @Test
    public void mockTest() {
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();

        Calculator calculator = new Calculator(dollarCalculator);
        Assertions.assertEquals(60_000, calculator.sum(10, 10));
        Assertions.assertEquals(0, calculator.minus(10, 10));
    }
}
