package services;


import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class CalculatorTest {
    Calculator calculator = new Calculator();
    int min = 1;
    int max = 1000;
    double value1 = ThreadLocalRandom.current().nextDouble(min, max + 1);
    double value2 = ThreadLocalRandom.current().nextDouble(min, max + 1);
    double value3 = ThreadLocalRandom.current().nextDouble(min, max + 1);
    double value4 = ThreadLocalRandom.current().nextDouble(min, max + 1);
    double value5 = ThreadLocalRandom.current().nextDouble(min, max + 1);


    @Test
    void addition() {
        assertThat( value1 + value2, equalTo(calculator.addition(value1,value2)));
    }

    @Test
    void subtraction() {
        assertThat(value1 - value2,equalTo(calculator.subtraction(value1,value2)));
    }

    @Test
    void multiplication() {
        assertThat(value1 * value2,equalTo(calculator.multiplication(value1,value2)));
    }

    @Test
    void division() {
        assertThat(value1 / value2,equalTo(calculator.division(value1,value2)));
    }

    @Test
    void calculateExpression() {
        String test = value1 + " / " + value2 + " + " + value3 + " - " +value4 + " * " + value5;
        assertThat((value1/value2) + value3 - (value4 * value5),equalTo(calculator.calculateExpression(test)));
    }
}