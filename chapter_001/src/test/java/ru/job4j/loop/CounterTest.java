package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class CounterTest {

    @Test
    public void whenFromOneToThreeThanTwo() {
        Counter counter = new Counter();
        int result = counter.add(1, 3);
        assertThat(result, is(2));
    }

    @Test
    public void whenFromTwoToTenThanThirty()    {
        Counter counter = new Counter();
        int result = counter.add(2, 11);
        assertThat(result, is(30));
    }

    @Test
    public void whenFromOneToTwelveThanFortyTwo()    {
        Counter counter = new Counter();
        int result = counter.add(1, 12);
        assertThat(result, is(42));
    }
}