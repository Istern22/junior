package ru.job4j.queue;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();
    private int capacity;
    private final Object monitor = this;

    public SimpleBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void offer(T value) {
        while (queue.size() == capacity) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.offer(value);
        monitor.notifyAll();
    }

    public synchronized T poll() {
        while (queue.size() == 0) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T value = queue.poll();
        monitor.notify();
        return value;
    }

    public int size() {
        return queue.size();
    }
}
