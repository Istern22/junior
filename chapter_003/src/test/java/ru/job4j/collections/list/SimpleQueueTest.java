package ru.job4j.collections.list;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleQueueTest {
    @Test
    public void whenCreateQueuePushItAndPollIt() {
        var queue = new SimpleQueue<Integer>();
        queue.push(0);
        queue.push(1);
        queue.push(2);
        assertThat(queue.poll(), is(0));
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
    }

    @Test
    public void whenCreateQueuePushItAndPollItTakeTurns() {
        var queue = new SimpleQueue<Integer>();
        queue.push(0);
        assertThat(queue.poll(), is(0));
        queue.push(1);
        queue.push(2);
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(nullValue()));
    }
}