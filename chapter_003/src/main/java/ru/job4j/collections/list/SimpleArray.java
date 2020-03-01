package ru.job4j.collections.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable {

    private Object[] items;
    private int index = 0;

    public SimpleArray(int size) {
        this.items = new Object[size];
    }

    public void add(T model) {
        this.items[index++] = model;
    }

    public void set(int position, T model) {
        if (position < 0 || position > index) {
            throw new IndexOutOfBoundsException();
        }
        this.items[position] = model;
    }

    public T get(int position) {
        if (position < 0 || position > index) {
            throw new IndexOutOfBoundsException();
        }
        return (T) this.items[position];
    }

    public void remove(int position) {
        if (position < 0 || position > index) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(items, position + 1, items, position, items.length - 1 - position);
        index--;
    }

    @Override
    public Iterator iterator() {

        return new Iterator() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T result = (T) items[currentIndex];
                currentIndex++;
                return result;
            }
        };
    }
}
