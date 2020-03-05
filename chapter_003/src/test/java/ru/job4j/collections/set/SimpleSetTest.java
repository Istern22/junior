package ru.job4j.collections.set;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

import static org.junit.Assert.*;

public class SimpleSetTest {
    @Test
    public void whenCreateSetAndIterate() {
        var set = new SimpleSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        var it = set.iterator();
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
    public void whenCreateSetWithDuplicateAndIterate() {
        var set = new SimpleSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(3);
        set.add(1);
        var it = set.iterator();
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
}