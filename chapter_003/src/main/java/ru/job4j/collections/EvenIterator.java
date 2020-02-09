package ru.job4j.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {

    private final int[] values;
    private int index = 0;

    public EvenIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        var result = false;
        if (index < values.length) {
            for (int i = index; i < values.length; i++) {
                if (values[i] % 2 == 0) {
                    index = i;
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Object next() {
        Object result = null;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        result = values[index];
        index++;
        return result;
    }
}
