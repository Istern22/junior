package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class StartUITest {
    private static final String MENU = new StringBuilder()
            .append("MENU")
            .append(System.lineSeparator())
            .append("0 - Add item")
            .append(System.lineSeparator())
            .append("1 - Show items")
            .append(System.lineSeparator())
            .append("2 - Update item")
            .append(System.lineSeparator())
            .append("3 - Delete item")
            .append(System.lineSeparator())
            .append("4 - Find item by id")
            .append(System.lineSeparator())
            .append("5 - Find items by name")
            .append(System.lineSeparator())
            .append("6 - Exit program")
            .append(System.lineSeparator())
            .toString();

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private final Consumer<String> output = new Consumer<String>() {

        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(new PrintStream(this.out));
        System.out.println("execute after method");
    }
/*    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Store tracker = new MemoryTracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker, output).init();
        assertThat(new String(out.toByteArray()), is(
                        new StringBuilder()
                                .append(MENU)
                                .append("----------ADD ITEM----------")
                                .append(System.lineSeparator())
                                .append(String.format("New item id: %s | name: %s | description: %s",
                                        tracker.findAll().get(0).getId(), tracker.findAll().get(0).getName(), tracker.findAll().get(0).getDesc()))
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        MemoryTracker tracker = new MemoryTracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "desc replace", "6"});
        new StartUI(input, tracker, output).init();
        assertThat(new String(out.toByteArray()), is(
                        new StringBuilder()
                                .append(MENU)
                                .append("----------UPDATE ITEM----------")
                                .append(System.lineSeparator())
                                .append(String.format("Item name: %s | description: %s",
                                        item.getName(), item.getDesc()))
                                .append(System.lineSeparator())
                                .append(String.format("Updated item id: %s | name: %s | description: %s",
                                        item.getId(), item.getName(), item.getDesc()))
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenShowAllItems() {
        MemoryTracker tracker = new MemoryTracker();
        Item item1 = tracker.add(new Item("name1", "desc1"));
        Item item2 = tracker.add(new Item("name2", "desc2"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker, output).init();
        assertThat(new String(out.toByteArray()), is(
                        new StringBuilder()
                                .append(MENU)
                                .append("----------ALL ITEMS----------")
                                .append(System.lineSeparator())
                                .append(String.format("Item id: %s | name: %s | description: %s",
                                        item1.getId(), item1.getName(), item1.getDesc()))
                                .append(System.lineSeparator())
                                .append(String.format("Item id: %s | name: %s | description: %s",
                                        item2.getId(), item2.getName(), item2.getDesc()))
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenDeleteItem() {
        MemoryTracker tracker = new MemoryTracker();
        Item item = tracker.add(new Item("name", "desc"));
        String id = item.getId();
        Input input = new StubInput(new String[] {"3", id, "6"});
        new StartUI(input, tracker, output).init();
        assertThat(new String(out.toByteArray()), is(
                        new StringBuilder()
                                .append(MENU)
                                .append("----------DELETE ITEM----------")
                                .append(System.lineSeparator())
                                .append("Item deleted")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindById() {
        MemoryTracker tracker = new MemoryTracker();
        Item item = tracker.add(new Item("name", "desc"));
        String id = item.getId();
        Input input = new StubInput(new String[]{"4", id, "6"});
        new StartUI(input, tracker, output).init();
        assertThat(new String(out.toByteArray()), is(
                        new StringBuilder()
                                .append(MENU)
                                .append("----------FIND ITEM BY ID----------")
                                .append(System.lineSeparator())
                                .append(String.format("Required item id: %s | name: %s | description: %s",
                                        item.getId(), item.getName(), item.getDesc()))
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindByName() {
        MemoryTracker tracker = new MemoryTracker();
        Item item = tracker.add(new Item("name", "desc"));
        String name = item.getName();
        Input input = new StubInput(new String[]{"5", name, "6"});
        new StartUI(input, tracker, output).init();
        assertThat(new String(out.toByteArray()), is(
                        new StringBuilder()
                                .append(MENU)
                                .append("----------FIND ITEM BY NAME----------")
                                .append(System.lineSeparator())
                                .append(String.format("Required item id: %s | name: %s | description: %s",
                                        item.getId(), item.getName(), item.getDesc()))
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }*/
}
