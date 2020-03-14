package ru.job4j.collections.map;

import java.util.Iterator;
import java.util.Objects;

public class SimpleHashMap<K, V> implements Iterable {

    private Node<K, V>[] table = new Node[4];
    private int size = 0;
    private int length = table.length;
    private int limit = (int) (length * 0.75);

    boolean insert(K key, V value) {
        if (size >= limit) {
            resize();
        }
        int hash = getHash(key);
        int index = getIndex(hash, this.length);

        if (table[index] == null) {
            table[index] = new Node(key, value, hash);
            size++;
            return true;
        }

        return false;
    }

    V get(K key) {
        int hash = getHash(key);
        int index = getIndex(hash, this.length);
        return table[index] == null || !table[index].getKey().equals(key) ? null : table[index].getValue();
    }

    boolean delete(K key) {
        int hash = getHash(key);
        int index = getIndex(hash, this.length);
        if (table[index].getKey().equals(key)) {
            table[index] = null;
            size--;
            return true;
        }
        return false;
    }

    int getIndex(int hash, int currLength) {
        return hash & (currLength - 1);
    }

    int getHash(K key) {
        if (key == null) {
            return 0;
        }
        int h = key.hashCode();
        return h ^ (h >>> 16);
    }

    public void resize() {
        var tmpLength = length + 4;
        var tempTable = new Node[tmpLength];
        for (var item : table) {
            if (item != null) {
                int hash = getHash(item.getKey());
                int index = getIndex(hash, tmpLength);
                if (tempTable[index] == null) {
                    tempTable[index] = item;
                }
            }
        }
        table = tempTable;
        length = table.length;
        limit = (int) (length * 0.75);
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator() {

            int currentIndex = 0;
            int count = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < length && count <= size;
            }

            @Override
            public K next() {
                K result = null;
                for (int i = currentIndex; i < length; i++) {
                    if (table[i] != null) {
                        result = table[i].getKey();
                        currentIndex = i + 1;
                        count++;
                        break;
                    }
                }
                return result;
            }
        };
    }

    private class Node<K, V> {
        K key;
        V value;
        int hash;

        public Node(K key, V value, int hash) {
            this.key = key;
            this.hash = hash;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Node node = (Node) obj;
            return this.key.equals(node.getKey());
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }
}