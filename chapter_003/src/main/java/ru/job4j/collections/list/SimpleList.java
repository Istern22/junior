package ru.job4j.collections.list;

public class SimpleList<E> {

    private int size = 0;
    private Node<E> first;

    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    public E delete(int index) {
        if (index >= size) {
           throw new IndexOutOfBoundsException();
        }
        E result = first.data;
        if (size == 1) {
            first = null;
        } else if (index == 0) {
            first = first.next;
        } else {
            var currentNode = first;
            var nextNode = first.next;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
                nextNode = nextNode.next;
            }
            result = nextNode.data;
            currentNode.next = nextNode.next;
        }
        size--;
        return result;
    }

    public E get(int index) {
        if (first == null) {
            return null;
        }
        Node<E> result = this.first;
        for (int i = 0; i < index && i < size; i++) {
            result = result.next;
        }
        return result.data;
    }

    public int getSize() {
        return this.size;
    }

    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}
