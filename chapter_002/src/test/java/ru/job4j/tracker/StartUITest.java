package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class StartUITest {
    private static final String MENU =
            "Меню:\r\n"
            + "0. Add new item\r\n"
            + "1. Show all items\r\n"
            + "2. Edit item\r\n"
            + "3. Delete item\r\n"
            + "4. Find item by id\r\n"
            + "5. Find items by name\r\n"
            + "6. Exit program\r\n";

    /**
     * Поле содержит дефолтный вывод в консоль.
     */
    private final PrintStream stdout = System.out;

    /**
     * Буфер для результата.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                        new StringBuilder()
                                .append(MENU)
                                .append("---------------Добавление новой заявки---------------")
                                .append(System.lineSeparator())
                                .append("---------------Новая заявка с getId: " + tracker.findAll()[0].getId() + "---------------")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "desc replace", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                        new StringBuilder()
                                .append(MENU)
                                .append("---------------Редактирование заявки---------------")
                                .append(System.lineSeparator())
                                .append("Ваша заявка: " + item.getName() + " Описание: " + item.getDesc())
                                .append(System.lineSeparator())
                                .append("---------------Заявка отредактирована---------------")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenShowAllItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("name1", "desc1"));
        Item item2 = tracker.add(new Item("name2", "desc2"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                        new StringBuilder()
                                .append(MENU)
                                .append("---------------Все существующие заявки---------------")
                                .append(System.lineSeparator())
                                .append("Имя: " + item1.getName() + " Описание: " + item1.getDesc() + " Время: " + item1.getTime())
                                .append(System.lineSeparator())
                                .append("Имя: " + item2.getName() + " Описание: " + item2.getDesc() + " Время: " + item2.getTime())
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        String id = item.getId();
        Input input = new StubInput(new String[] {"3", id, "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                        new StringBuilder()
                                .append(MENU)
                                .append("---------------Удаление заявки---------------")
                                .append(System.lineSeparator())
                                .append("---------------Заявка удалена---------------")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        String id = item.getId();
        Input input = new StubInput(new String[]{"4", id, "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                        new StringBuilder()
                                .append(MENU)
                                .append("---------------Поиск заявки по id---------------")
                                .append(System.lineSeparator())
                                .append("---------------Заявка найдена---------------")
                                .append(System.lineSeparator())
                                .append("Ваша заявка: " + item.getName() + " Описание: " + item.getDesc())
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        String name = item.getName();
        Input input = new StubInput(new String[]{"5", name, "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                        new StringBuilder()
                                .append(MENU)
                                .append("---------------Поиск заявок по имени---------------")
                                .append(System.lineSeparator())
                                .append("---------------Заявки найдены---------------")
                                .append(System.lineSeparator())
                                .append("Имя: " + item.getName() + " Описание: " + item.getDesc() + " Время: " + item.getTime())
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
