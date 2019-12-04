package ru.job4j.tracker;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class StartUI {

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    private final Consumer<String> output;
    /**
     * Конструктор инициализирующий поля.
     * @param input ввод данных;
     * @param tracker хранилище заявок;
     * @param output вывод
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Основной цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        menu.show();
        while (true) {
            int key = Integer.valueOf(input.ask("SELECT: ", range));
            menu.select(key);
            if (key == 6) {
                break;
            }
        }
    }

    /**
     * Запуск программы
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker(), System.out::println
        ).init();
    }
}
