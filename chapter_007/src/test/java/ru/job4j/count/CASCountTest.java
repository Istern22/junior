package ru.job4j.count;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CASCountTest {

    @Test
    public void whenOneThread() {
        CASCount count = new CASCount();
        count.increment();
        count.increment();
        count.increment();
        assertThat(count.get(), is(3));
    }

    @Test
    public void whenThreeThreads() throws InterruptedException {
        CASCount count = new CASCount();
        Thread first = new Thread(
                () -> {
                    count.increment();
                }
        );
        Thread second = new Thread(
                () -> {
                    count.increment();
                }
        );
        Thread third = new Thread(
                () -> {
                    for (int i = 0; i < 5; i++) {
                        count.increment();
                    }
                }
        );
        first.start();
        second.start();
        third.start();
        first.join();
        second.join();
        third.join();
        assertThat(count.get(), is(7));
    }
}