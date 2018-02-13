package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class SquareTest {
    @Test
    public void whenBoundEqualsFiveThanArrayOneFourNineSixteenTwentyFive() {
        Square square = new Square();
        int[] result= square.calculate(5);
        int[] expected = {1, 4, 9, 16, 25};
        assertThat(result, is(expected));
    }

    @Test
    public void whenBoundEqualsTwoThanArrayOneFour() {
        Square square = new Square();
        int[] result = square.calculate(2);
        int[] expected = {1, 4};
        assertThat(result, is(expected));
    }

    @Test
    public void whenBoundEqualsTenThanArrayOneFourNineSixteenTwentyFiveThirtySixFortyNine() {
        Square square = new Square();
        int[] result = square.calculate(7);
        int[] expected = {1, 4, 9, 16, 25, 36, 49};
        assertThat(result, is(expected));
    }

}
