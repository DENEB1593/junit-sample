package com.example.junitstudy.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest    // Mock Container 시작
public class DollarCalculatorTest {
    // 스프링에서 관리하는 목빈
    @MockBean
    private MarketApi marketApi;

    @Autowired
    private Calculator dollarCalculator;

    @Test
    void dollarCalculatorTest() {
        Mockito.when(marketApi.connect()).thenReturn(3000);

        int sum = dollarCalculator.sum(10, 10);
        int minus = dollarCalculator.minus(10, 10);

        Assertions.assertEquals(60_000, sum);
        Assertions.assertEquals(0, minus);
    }


}
