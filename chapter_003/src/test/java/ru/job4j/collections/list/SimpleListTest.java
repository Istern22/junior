package ru.job4j.collections.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class SimpleListTest {

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        SimpleList<Integer> list = new SimpleList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        SimpleList<Integer> list = new SimpleList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenEmptyList() {
        SimpleList<String> list = new SimpleList<>();
        assertThat(list.get(1), is(nullValue()));
    }

   @Test
    public void whenTestList() {
        SimpleList<String> list = new SimpleList<>();
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
        SimpleList<String> list = new SimpleList<>();
        assertThat(list.delete(1), is(nullValue()));
    }

    @Test
    public void whenDeleteOneElementFromListWithOneElement() {
        SimpleList<Integer> list = new SimpleList<>();
        list.add(0);
        assertThat(list.delete(0), is(0));
        assertThat(list.get(0), is(nullValue()));
    }

    @Test
    public void whenDeleteOneElementFromListWithOneElementWhenOtherNull() {
        SimpleList<Integer> list = new SimpleList<>();
        list.add(0);
        list.add(null);
        assertThat(list.delete(0), is(nullValue()));
        assertThat(list.get(0), is(0));
    }

    @Test
    public void whenDeleteOneElementFromListWithThreeElements() {
        SimpleList<Integer> list = new SimpleList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThat(list.delete(0), is(3));
        assertThat(list.get(0), is(2));
    }

    @Test
    public void whenDeleteOneElementFromCenterOfListWithThreeElements() {
        SimpleList<Integer> list = new SimpleList<>();
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
        SimpleList<Integer> list = new SimpleList<>();
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
