package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription");
        tracker.add(previous);
        Item next = new Item("test2", "testDescription");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItemThenNewArray() {
        Tracker tracker = new Tracker();
        Item item0 = new Item("name0", "description0");
        tracker.add(item0);
        Item item1 = new Item("name1", "description1");
        tracker.add(item1);
        Item item2 = new Item("name2", "description2");
        tracker.add(item2);
        Item item3 = new Item("name3", "description3");
        tracker.add(item3);
        Item item4 = new Item("name4", "description4");
        tracker.add(item4);
        boolean result = tracker.delete(item1.getId());
        assertThat(result, is(true));
    }

    @Test
    public void whenDeleteNotFoundedItemThenFalse() {
        Tracker tracker = new Tracker();
        Item item0 = new Item("name0", "description0");
        tracker.add(item0);
        Item item1 = new Item("name1", "description1");
        tracker.add(item1);
        Item item2 = new Item("name2", "description2");
        tracker.add(item2);
        Item item3 = new Item("name3", "description3");
        tracker.add(item3);
        Item item4 = new Item("name4", "description4");
        tracker.add(item4);
        boolean result = tracker.delete("12345");
        assertThat(result, is(false));
    }

    @Test
    public void whenFindAllThenNewArray() {
        Tracker tracker = new Tracker();
        Item item0 = new Item("name0", "description0");
        tracker.add(item0);
        Item item1 = new Item("name1", "description1");
        tracker.add(item1);
        Item item2 = new Item("name2", "description2");
        tracker.add(item2);
        Item item3 = new Item("name3", "description3");
        tracker.add(item3);
        Item item4 = new Item("name4", "description4");
        tracker.add(item4);
        ArrayList<Item> result = tracker.findAll();
        ArrayList<Item> expected = new ArrayList<Item>(Arrays.asList(item0, item1, item2, item3, item4));
        assertThat(result, is(expected));
    }

    @Test
    public void whenFindAllAndDeleteThenNewArray() {
        Tracker tracker = new Tracker();
        Item item0 = new Item("name0", "description0");
        tracker.add(item0);
        Item item1 = new Item("name1", "description1");
        tracker.add(item1);
        Item item2 = new Item("name2", "description2");
        tracker.add(item2);
        Item item3 = new Item("name3", "description3");
        tracker.add(item3);
        Item item4 = new Item("name4", "description4");
        tracker.add(item4);
        tracker.delete(item1.getId());
        ArrayList<Item> result = tracker.findAll();
        ArrayList<Item> expected = new ArrayList<Item>(Arrays.asList(item0, item2, item3, item4));
        assertThat(result, is(expected));
    }

    @Test
    public void whenFindAllNamesThanNewArray() {
        Tracker tracker = new Tracker();
        Item item0 = new Item("name0", "description0");
        tracker.add(item0);
        Item item1 = new Item("name1", "description1");
        tracker.add(item1);
        Item item2 = new Item("name0", "description2");
        tracker.add(item2);
        Item item3 = new Item("name3", "description3");
        tracker.add(item3);
        Item item4 = new Item("name0", "description4");
        tracker.add(item4);
        ArrayList<Item> result = tracker.findByName("name0");
        ArrayList<Item> expected = new ArrayList<Item>(Arrays.asList(item0, item2, item4));
        assertThat(result, is(expected));
    }
}


