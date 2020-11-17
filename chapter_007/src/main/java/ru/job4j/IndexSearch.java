package ru.job4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class IndexSearch<T> extends RecursiveTask<Integer> {

    T[] array;
    int start, end;
    T item;

    public IndexSearch(T[] array, int start, int end, T item) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.item = item;
    }

    public Integer search() {
        int result = -1;
        for (int i = start; i < end; i++) {
            if (array[i].equals(item)) {
                result = i;
            }
        }
        return result;
    }

    @Override
    protected Integer compute() {
        if (end - start < 10) {
            return search();
        }
        int middle = (start + end) / 2;
        IndexSearch search1 = new IndexSearch(array, start, middle, item);
        IndexSearch search2 = new IndexSearch(array, middle, end, item);
        search1.fork();
        search2.fork();
        if (!search1.join().equals(-1)) {
            return (Integer) search1.join();
        }
        if (!search2.join().equals(-1)) {
            return (Integer) search2.join();
        }
        return -1;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        Double[] array = new Double[5000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (double) i + 1;
        }
        IndexSearch<Double> task = new IndexSearch<Double>(array, 0, array.length, (double) 2300);
        int result = pool.invoke(task);
        System.out.println(result);
    }
}
