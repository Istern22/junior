package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CalculatorTest {
    @Test
    public void whenLinearFunction() {
        Calculator calculator = new Calculator();
        List<Double> result = calculator.range(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        Calculator calculator = new Calculator();
        List<Double> result = calculator.range(5, 8, x -> 2 * Math.pow(x + 1, 2));
        List<Double> expected = Arrays.asList(72D, 98D, 128D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunction() {
        Calculator calculator = new Calculator();
        List<Double> result = calculator.range(5, 8, x -> 2 * Math.log(x + 3));
        List<Double> expected = Arrays.asList(4.1588830833596715, 4.394449154672439, 4.605170185988092);
        assertThat(result, is(expected));
    }
}
