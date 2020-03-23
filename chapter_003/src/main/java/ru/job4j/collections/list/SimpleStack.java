package ru.job4j.collections.list;

import java.util.EmptyStackException;

public class SimpleStack<T> {

    private SimpleLinked<T> linked = new SimpleLinked<T>();

    public T poll() {
        if (!linked.iterator().hasNext()) {
            throw new EmptyStackException();
        }
        return linked.deleteFirst();
    }

    public void push(T value) {
        linked.add(value);
    }

    public boolean isEmpty() {
        return linked.isEmpty();
    }
}