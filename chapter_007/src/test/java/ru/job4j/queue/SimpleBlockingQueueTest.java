package ru.job4j.queue;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class SimpleBlockingQueueTest {
    @Test
    public void whenPollFirst() throws InterruptedException {
        SimpleBlockingQueue queue = new SimpleBlockingQueue(2);
        Thread consumer = new Thread(
                () -> {
                    queue.poll();
                }
        );
        Thread producer = new Thread(
                () -> {
                    queue.offer("0");
                }
        );
        producer.start();
        consumer.start();
        consumer.join();
        producer.join();
        assertThat(queue.size(), is(0));
    }

    @Test
    public void whenOfferFirst() throws InterruptedException {
        SimpleBlockingQueue queue = new SimpleBlockingQueue(2);
        Thread producer = new Thread(
                () -> {
                    queue.offer("0");
                }
        );
        Thread consumer = new Thread(
                () -> {
                    queue.poll();
                }
        );
        consumer.start();
        producer.start();
        consumer.join();
        producer.join();
        assertThat(queue.size(), is(0));
    }
}