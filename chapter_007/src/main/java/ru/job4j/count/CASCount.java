package ru.job4j.count;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class CASCount<T> {

    private final AtomicReference<Integer> count = new AtomicReference<>();

    public CASCount() {
        count.set(0);
    }

    public void increment() {
        int value;
        int next;
        do {
            value = count.get();
            next = value + 1;
        } while (!count.compareAndSet(value, next));
    }

    public int get() {
        return count.get();
    }
}

