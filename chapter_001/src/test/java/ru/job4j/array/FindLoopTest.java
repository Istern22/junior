package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class FindLoopTest {
    @Test
    public void whenIndexOfValueEqualsTwo() {
        FindLoop findloop = new FindLoop();
        int[] array = {1, 10, 30, 55, 85};
        int result = findloop.indexOf(array, 30);
        assertThat(result, is(2));
    }

    @Test
    public void whenIndexOfValueDoesNotExist() {
        FindLoop findloop = new FindLoop();
        int[] array = {1, 10, 30, 55, 85};
        int result = findloop.indexOf(array, 60);
        assertThat(result, is(-1));
    }
}
