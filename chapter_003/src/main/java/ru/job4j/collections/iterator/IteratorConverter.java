package ru.job4j.collections.iterator;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorConverter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> currentIterator = it.hasNext() ? it.next() : Collections.emptyIterator();

            @Override
            public boolean hasNext() {
                boolean result = false;
                while (it.hasNext() && !currentIterator.hasNext()) {
                    currentIterator = it.next();
                }
                if (currentIterator.hasNext()) {
                    result = true;
                }
                return result;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return currentIterator.next();
            }
        };
    }
}
