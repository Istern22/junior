package ru.job4j.synch;

import net.jcip.annotations.ThreadSafe;
import ru.job4j.collections.list.DynamicArray;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ThreadSafe
public class SingleLockList<T> implements Iterable<T> {

    private DynamicArray<T> list = new DynamicArray<>();
    DynamicArray<T> listCopy = new DynamicArray<>();

    public synchronized void add(T value) {
        list.add(value);

    }

    public synchronized T get(int index) {
        return list.get(index);
    }

    @Override
    public  synchronized Iterator<T> iterator() {
        copy(this.list);
        return listCopy.iterator();

    }

    private void copy(DynamicArray<T> list) {
        list.forEach(item -> listCopy.add((T) item));
    }
}
