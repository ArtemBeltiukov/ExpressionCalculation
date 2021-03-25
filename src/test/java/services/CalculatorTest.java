package services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


class CalculatorTest {
    Calculator calculator = new Calculator();

    double value1 = 1;
    double value2 = 2;
    double value3 = 3;
    double value4 = 4;
    double value5 = 5;

    private static Stream<Arguments> provideIntsForDivisionByZero() {
        return Stream.of(
                Arguments.of(1, 0)
        );
    }

    @Test
    void additionTest() {
        assertThat( value1 + value2, equalTo(calculator.addition(value1,value2)));
    }

    @Test
    void subtractionTest() {
        assertThat(value1 - value2,equalTo(calculator.subtraction(value1,value2)));
    }

    @Test
    void multiplicationTest() {
        assertThat(value1 * value2,equalTo(calculator.multiplication(value1,value2)));
    }

    @Test
    void divisionTest() {
        assertThat(value1 / value2,equalTo(calculator.division(value1,value2)));
    }


    @ParameterizedTest
    @MethodSource("provideIntsForDivisionByZero")
    void divisionByZeroTest(int v1, int v2 ) {
        Assert.assertThrows(IllegalArgumentException.class,()->calculator.division(v1,v2));
    }

    @Test
    void calculateExpressionTest() {
        String test = value1 + " / " + value2 + " + " + value3 + " - " +value4 + " * " + value5;
        assertThat((value1/value2) + value3 - (value4 * value5),equalTo(calculator.calculateExpression(test)));
    }
}