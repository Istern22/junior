package ru.job4j.collections.list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class SimpleArrayTest {


    @Test
    public void whenGetItems() {
        SimpleArray<Integer> intArray = new SimpleArray<>(5);
        intArray.add(1);
        intArray.add(null);
        intArray.add(3);
        assertThat(intArray.get(0), is(1));
        assertThat(intArray.get(1), is(nullValue()));
        assertThat(intArray.get(2), is(3));
        intArray.set(0, 22);
        assertThat(intArray.get(0), is(22));
        intArray.remove(0);
        assertThat(intArray.get(0), is(nullValue()));
    }

    @Test
    public void whenRemoveItems() {
        SimpleArray<Integer> intArray = new SimpleArray<>(3);
        intArray.add(1);
        intArray.add(2);
        intArray.add(0);
        assertThat(intArray.get(0), is(1));
        intArray.remove(0);
        assertThat(intArray.get(0), is(2));
        assertThat(intArray.get(1), is(0));
        assertThat(intArray.get(2), is(0));
    }

    @Test
    public void whenIterate() {
        SimpleArray<Integer> intArray = new SimpleArray<>(3);
        intArray.add(1);
        intArray.add(2);
        var it = intArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));

    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenNull() {
        SimpleArray<Integer> intArray = new SimpleArray<>(3);
        intArray.add(1);
        intArray.add(2);
        intArray.remove(3);
        assertThat(intArray.get(3), is(0));
    }

    @Test
    public void whenNullItems() {
        SimpleArray<Integer> intArray = new SimpleArray<>(3);
        intArray.add(1);
        intArray.add(2);
        assertThat(intArray.get(2), is(nullValue()));
    }

    @Test
    public void whenRemove() {
        SimpleArray<Integer> intArray = new SimpleArray<>(5);
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);
        intArray.add(4);
        intArray.add(5);
        intArray.remove(1);
        assertThat(intArray.get(1), is(3));
    }

    @Test
    public void whenIterateEmptyArray() {
        SimpleArray<Integer> intArray = new SimpleArray<>(10);
        assertThat(intArray.iterator().hasNext(), is(false));
    }

    @Test
    public void whenIterateArrayWithEmptyElements() {
        SimpleArray<Integer> intArray = new SimpleArray<>(6);
        intArray.add(null);
        intArray.add(1);
        intArray.add(null);
        Iterator<Integer> it = intArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(nullValue()));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(nullValue()));
        assertThat(it.hasNext(), is(false));
    }
}