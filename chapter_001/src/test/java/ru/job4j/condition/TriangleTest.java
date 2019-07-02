package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point first = new Point(0, 0);
        Point second = new Point(0, 2);
        Point third = new Point(2, 0);
        Triangle triangle = new Triangle(first, second, third);
        double result = triangle.area();
        first.info();
        second.info();
        third.info();
        System.out.println(String.format("Result is %s", result));
        double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));
    }
}
