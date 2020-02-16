package ru.job4j.collections.list;

import org.junit.Test;
import org.junit.Before;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class SimpleArrayListTest {

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenEmptyList() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        assertThat(list.get(1), is(nullValue()));
    }

   @Test
    public void whenTestList() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("1");
        list.add("2");
        list.add("");
        list.add("5");
        assertThat(list.get(0), is("5"));
        assertThat(list.get(1), is(""));
        assertThat(list.get(2), is("2"));
        assertThat(list.get(3), is("1"));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenDeleteElementFromNullList() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        assertThat(list.delete(1), is(nullValue()));
    }

    @Test
    public void whenDeleteOneElementFromListWithOneElement() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();
        list.add(0);
        assertThat(list.delete(0), is(0));
        assertThat(list.get(0), is(nullValue()));
    }

    @Test
    public void whenDeleteOneElementFromListWithOneElementWhenOtherNull() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();
        list.add(0);
        list.add(null);
        assertThat(list.delete(0), is(nullValue()));
        assertThat(list.get(0), is(0));
    }

    @Test
    public void whenDeleteOneElementFromListWithThreeElements() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThat(list.delete(0), is(3));
        assertThat(list.get(0), is(2));
    }

    @Test
    public void whenDeleteOneElementFromCenterOfListWithThreeElements() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertThat(list.delete(2), is(2));
        assertThat(list.get(0), is(4));
        assertThat(list.get(1), is(3));
        assertThat(list.get(2), is(1));
    }

    @Test
    public void whenDeleteOneElementFromCenterOfListWithFiveElements() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        assertThat(list.delete(3), is(2));
        assertThat(list.get(0), is(5));
        assertThat(list.get(1), is(4));
        assertThat(list.get(2), is(3));
        assertThat(list.get(3), is(1));
        assertThat(list.delete(3), is(1));
        assertThat(list.get(0), is(5));
        assertThat(list.get(1), is(4));
        assertThat(list.get(2), is(3));
        assertThat(list.delete(0), is(5));
        assertThat(list.delete(1), is(3));
        assertThat(list.get(0), is(4));

    }

}
