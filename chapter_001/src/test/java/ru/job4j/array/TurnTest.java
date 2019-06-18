package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class TurnTest {
    @Test
    public void whenArrayOfFiveElementsThanReturnArrayTurned() {
        Turn turn = new Turn();
        int[] array = {1, 2, 3, 4, 5};
        int[] resultArray = turn.back(array);
        int[] expected = {5, 4, 3, 2, 1};
        assertThat(resultArray, is(expected));
    }

    @Test
    public void whenArrayOfFourElementsThanReturnArrayTurned() {
        Turn turn = new Turn();
        int[] array = {1, 2, 3, 4};
        int[] resultArray = turn.back(array);
        int[] expected = {4, 3, 2, 1};
        assertThat(resultArray, is(expected));
    }

}
