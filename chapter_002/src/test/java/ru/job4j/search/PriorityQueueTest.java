package ru.job4j.search;

import org.junit.Test;
import static  org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        queue.put(new Task("low", 8));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenOnePriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("low2", 5));
        Task result = queue.take();
        assertThat(result.getDesc(), is("low2"));
    }

    @Test
    public void whenLowPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("urgent", 1));
        queue.put(new Task("low", 5));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenRandomPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("low2", 6));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        queue.put(new Task("urgent2", 2));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
}