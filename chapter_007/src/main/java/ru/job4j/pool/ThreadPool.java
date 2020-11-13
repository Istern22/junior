package ru.job4j.pool;

import ru.job4j.queue.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;

public class ThreadPool {
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(10);
    private final int size = Runtime.getRuntime().availableProcessors();

    public ThreadPool() throws InterruptedException {
        for (int i = size; i > 0; i--) {
            Thread thread = new Thread(
                    () -> {
                        try {
                            while (!Thread.currentThread().isInterrupted()) {
                                tasks.poll().run();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            );
            thread.start();
            threads.add(thread);
            Thread.sleep(1000);
        }
    }

    public void work(Runnable job) throws InterruptedException {
        tasks.offer(job);
    }

    public void shutdown() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPool pool = new ThreadPool();
        pool.work(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 1");
            }
        });
        pool.work(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()  + " 2");
            }
        });
        pool.work(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 3");
            }
        });
        pool.work(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 4");
            }
        });
        pool.shutdown();
    }
}