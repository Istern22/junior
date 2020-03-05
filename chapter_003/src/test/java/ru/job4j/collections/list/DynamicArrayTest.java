package ru.job4j.collections.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class DynamicArrayTest {

    @Test
    public void whenAddItems() {
        var dynamicArray = new DynamicArray<Integer>();
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        assertThat(dynamicArray.get(0), is(1));
        assertThat(dynamicArray.get(3), is(4));
    }

    @Test
    public void whenIterateArray() {
        var dynamicArray = new DynamicArray<Integer>();
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        var it = dynamicArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenIterateArrayWithModification() {
        var dynamicArray = new DynamicArray<Integer>();
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        var it = dynamicArray.iterator();
        dynamicArray.add(4);
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenAddNullAndGetAndIterateIt() {
        var dynamicArray = new DynamicArray<Integer>();
        dynamicArray.add(1);
        dynamicArray.add(null);
        assertThat(dynamicArray.get(0), is(1));
        assertThat(dynamicArray.get(1), is(nullValue()));
        var it = dynamicArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(nullValue()));
        assertThat(it.hasNext(), is(false));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenGetNotExistedIndex() {
        var dynamicArray = new DynamicArray<Integer>();
        dynamicArray.add(1);
        assertThat(dynamicArray.get(10), is(1));
    }
}