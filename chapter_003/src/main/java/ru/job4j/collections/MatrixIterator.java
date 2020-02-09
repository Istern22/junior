package ru.job4j.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator {

    private final int[][] values;
    private int row = 0;
    private int column = 0;

    public MatrixIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return  row < values.length && (row != values.length - 1 || column < values[row].length);
    }

    @Override
    public Object next() {
        Object result;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        result = values[row][column++];
        if (column == values[row].length) {
            row++;
            column = 0;
        }
        return result;
    }
}