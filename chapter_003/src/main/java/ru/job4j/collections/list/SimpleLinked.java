package ru.job4j.collections.list;

import org.w3c.dom.Node;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinked<E> implements Iterable {

    private int size = 0;
    private Node<E> first;
    private int modCount = 0;

    public void add(E item) {
        var newItem = new Node(item);
        newItem.next = this.first;
        this.first = newItem;
        size++;
        modCount++;
    }

    public E get(int index) {
        if (first == null) {
            return null;
        }
        var result = this.first;
        for (int i = 0; i < size && i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    public E deleteFirst() {
        if (first == null) {
            return null;
        }
        E result = first.data;
        first = first.next;
        return result;
    }

    @Override
    public Iterator iterator() {

        return new Iterator() {

            private int currentIndex = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                var result = first;
                for (int i = 0; i < currentIndex; i++) {
                    result = result.next;
                }
                currentIndex++;
                return result.data;
            }
        };
    }

    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}