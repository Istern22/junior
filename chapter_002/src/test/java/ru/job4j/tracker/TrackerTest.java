package ru.job4j.tracker;

import org.junit.Test;
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
        //Добавляем заявку в трекер. Теперь в объект проиницилизирован id.
        tracker.add(previous);
        //Создаем новую заявку.
        Item next = new Item("test2", "testDescription");
        //Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        //Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        //Проверяем, что заявка с таким id имеет новое имя test2.
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
        Item[] result = tracker.findAll();
        Item[] expected = {item0, item1, item2, item3, item4};
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
        Item[] result = tracker.findAll();
        Item[] expected = {item0, item2, item3, item4};
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
        Item[] result = tracker.findByName("name0");
        Item[] expected = {item0, item2, item4};
        assertThat(result, is(expected));
    }
}


