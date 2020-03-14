package ru.job4j.collections.set;

import ru.job4j.collections.list.DynamicArray;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable {

    private DynamicArray<T> set = new DynamicArray();

    public void add(T value) {
        var exist = false;
        var it = set.iterator();

        while (it.hasNext()) {
            if (it.next().equals(value)) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            set.add(value);
        }
    }

    @Override
    public Iterator iterator() {
        return set.iterator();
    }
}