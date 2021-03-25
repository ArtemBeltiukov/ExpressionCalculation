package services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


class CalculatorTest {
    Calculator calculator = new Calculator();

    double value1 = 1;
    double value2 = 2;
    double value3 = 3;
    double value4 = 4;
    double value5 = 5;

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


    @ParameterizedTest
    @CsvSource({"1,0"})
    void divisionByZero(int v1, int v2 ) {
        Assert.assertThrows(IllegalArgumentException.class,()->calculator.division(v1,v2));
    }

    @Test
    void calculateExpression() {
        String test = value1 + " / " + value2 + " + " + value3 + " - " +value4 + " * " + value5;
        assertThat((value1/value2) + value3 - (value4 * value5),equalTo(calculator.calculateExpression(test)));
    }
}