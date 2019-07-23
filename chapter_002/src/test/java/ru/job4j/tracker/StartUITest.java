package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    /**
     * Создаем tracker.
     * Создаем StubInput с последовательностью действий.
     * Создаем StartUI и вызываем метод init()
     * Проверяем, что нулевой элемент массива в трекере
     * содержит имя, введенное при эмуляции.
     */
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "desc replace", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenShowAllItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("name1", "desc1"));
        Item item2 = tracker.add(new Item("name2", "desc2"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(new Item[]{item1, item2}));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        String id = item.getId();
        Input input = new StubInput(new String[] {"3", id, "6"});
        new StartUI(input, tracker).init();
        Item result = null;
        assertThat(tracker.findById(id), is(result));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        String id = item.getId();
        Input input = new StubInput(new String[]{"4", id, "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(id), is(item));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        String name = item.getName();
        Input input = new StubInput(new String[]{"5", name, "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(name), is(new Item[]{item}));
    }
}
