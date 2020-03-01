package ru.job4j.collections.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DynamicListTest {
    @Test
    public void whenCreateListAndAddElements() {
        var list = new DynamicList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThat(list.get(0), is(3));
        assertThat(list.get(1), is(2));
        assertThat(list.get(2), is(1));
    }

    @Test
    public void whenCreateListAndAddElementsAndIterateIt() {
        var list = new DynamicList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        var it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(false));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenIterateListWithModification() {
        var list = new DynamicList<Integer>();
        list.add(1);
        var it = list.iterator();
        list.add(2);
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
    }
}