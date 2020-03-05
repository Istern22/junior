package ru.job4j.collections.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<T> implements Iterable {

    private Object[] items;
    private int index = 0;
    private int size = 3;
    private int modCount = 0;

    public DynamicArray() {
        items = new Object[size];
    }

    public void add(T item) {
        if (index == size) {
            size = size + 3;
            var itemsOver = new Object[size];
            System.arraycopy(items, 0, itemsOver, 0, index);
            items = itemsOver;
            modCount++;
        }
        this.items[index++] = item;
    }

    public T get(int position) {
        if (position < 0 || position > index) {
            throw new IndexOutOfBoundsException();
        }
        return (T) this.items[position];
    }

    @Override
    public Iterator iterator() {

        return new Iterator() {

            private int currentIndex = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return currentIndex < index;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                T result = (T) items[currentIndex];
                currentIndex++;
                return result;
            }
        };
    }
}