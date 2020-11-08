package ru.job4j.buffer;

import ru.job4j.queue.SimpleBlockingQueue;

public class ParallelSearch {

    public static void main(String[] args) throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(10);
        final Thread consumer = new Thread(
                () -> {
                    while (!queue.isEmpty() || !Thread.currentThread().isInterrupted()) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();

                        }
                        System.out.println(queue.poll());
                    }
                }
        );
        consumer.start();
        Thread producer = new Thread(
                () -> {
                    for (int index = 0; index != 3; index++) {
                        queue.offer(index);
                    }
                }
        );
        producer.start();
        producer.join();
        consumer.interrupt();
        consumer.join();
        System.out.println(producer.getState());
        System.out.println(consumer.getState());
    }
}
