package ru.job4j.collections.map;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class SimpleHashMapTest {

    @Test
    public void whenCreateHashMapAndFillIt() {
        var map = new SimpleHashMap<String, Integer>();
        map.insert("user0", 0);
        map.insert("user1", 1);
        map.insert("user2", 2);
        assertThat(map.get("user0"), is(0));
        assertThat(map.get("user1"), is(1));
        assertThat(map.get("user2"), is(2));
    }

    @Test
    public void whenCreateHashMapAndIterateIt() {
        var map = new SimpleHashMap<String, Integer>();
        map.insert("user0", 0);
        map.insert("user1", 1);
        map.insert("user2", 2);
        var it = map.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("user1"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("user2"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("user0"));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenCreateHashMapAndResizeIt() {
        var map = new SimpleHashMap<String, Integer>();
        map.insert("user0", 0);
        map.insert("user1", 1);
        map.insert("user2", 2);
        map.insert("user3", 3);
        map.insert("user4", 4);
        assertThat(map.get("user0"), is(0));
        assertThat(map.get("user1"), is(1));
        assertThat(map.get("user2"), is(2));
        assertThat(map.get("user3"), is(3));
        assertThat(map.get("user4"), is(4));
    }

    @Test
    public void whenCreateHashMapAndDeleteItems() {
        var map = new SimpleHashMap<String, Integer>();
        map.insert("user0", 0);
        map.insert("user1", 1);
        map.insert("user2", 2);
        map.insert("user3", 3);
        map.insert("user4", 4);
        map.delete("user0");
        map.delete("user1");
        map.delete("user2");
        map.delete("user4");
        assertThat(map.get("user0"), is(nullValue()));
        assertThat(map.get("user1"), is(nullValue()));
        assertThat(map.get("user2"), is(nullValue()));
        assertThat(map.get("user3"), is(3));
        assertThat(map.get("user4"), is(nullValue()));
    }
}