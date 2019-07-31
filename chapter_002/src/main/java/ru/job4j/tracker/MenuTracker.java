package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class MenuTracker {
    /**
     * @param хранит ссылку на объект
     */
    private Input input;

    /**
     * @param хранит ссылку на объект
     */
    private Tracker tracker;

    /**
     * @param хранит ссылку на массив типа UserAction
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор     *
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню     *
     *
     * @return длину массива
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив
     */
    public void fillActions() {
        this.actions.add(new AddItem());
        this.actions.add(new ShowItems());
        this.actions.add(new UpdateItem());
        this.actions.add(new DeleteItem());
        this.actions.add(new FindItemById());
        this.actions.add(new FindItemsByName());
        this.actions.add(new ExitProgram());
    }

    /**
     * В зависимости от указанного ключа, метод выполняет соответсвтующие действия     *
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню
     */
    public void show() {
        System.out.println("Меню:");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private static class AddItem implements UserAction {
        private static final int ADD = 0;

        @Override
        public int key() {
            return ADD;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------Добавление новой заявки---------------");
            String name = input.ask("Введите имя заявки: ");
            String desc = input.ask("Введите описание заявки: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("---------------Новая заявка с getId: " + item.getId() + "---------------");
        }

        @Override
        public String info() {
            return key() + ". Add new item";
        }
    }

    private static class ShowItems implements UserAction {
        private static final int SHOW_ALL = 1;

        @Override
        public int key() {
            return SHOW_ALL;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------Все существующие заявки---------------");
            Item[] items = tracker.findAll();
            for (Item item : items) {
                System.out.println("Имя: " + item.getName() + " Описание: " + item.getDesc() + " Время: " + item.getTime());
            }
        }

        @Override
        public String info() {
            return key() + ". Show all items";
        }
    }

    private static class UpdateItem implements UserAction {
        private static final int EDIT = 2;

        @Override
        public int key() {
            return EDIT;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------Редактирование заявки---------------");
            String id = input.ask("Введите id заявки, которую нужно отредактировать");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println("Ваша заявка: " + item.getName() + " Описание: " + item.getDesc());
                String name = input.ask("Отредактируйте имя заявки: ");
                String desc = input.ask("Отредактируйте описание заявки: ");
                Item newItem = new Item(name, desc);
                newItem.setId(id);
                tracker.replace(id, newItem);
                System.out.println("---------------Заявка отредактирована---------------");
            } else {
                System.out.println("Заявки не существует.");
            }
        }

        @Override
        public String info() {
            return key() + ". Edit item";
        }
    }

    private static class DeleteItem implements UserAction {
        private static final int DELETE = 3;

        @Override
        public int key() {
            return DELETE;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------Удаление заявки---------------");
            String id = input.ask("Введите id заявки, которую нужно удалить");
            if (tracker.delete(id)) {
                System.out.println("---------------Заявка удалена---------------");
            } else {
                System.out.println("---------------Заявки не существует---------------");
            }
        }

        @Override
        public String info() {
            return key() + ". Delete item";
        }
    }

    private static class FindItemById implements UserAction {
        private static final int FIND_BY_ID = 4;

        @Override
        public int key() {
            return FIND_BY_ID;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------Поиск заявки по id---------------");
            String id = input.ask("Введите id заявки, которую нужно найти");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println("---------------Заявка найдена---------------");
                System.out.println("Ваша заявка: " + item.getName() + " Описание: " + item.getDesc());
            } else {
                System.out.println("---------------Заявка не найдена---------------");
            }
        }

        @Override
        public String info() {
            return key() + ". Find item by id";
        }
    }

    private static class FindItemsByName implements UserAction {
        private static final int FIND_BY_NAME = 5;

        @Override
        public int key() {
            return FIND_BY_NAME;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------Поиск заявок по имени---------------");
            String name = input.ask("Введите имя заявки, которую нужно найти");
            Item[] items = tracker.findByName(name);
            if (items.length != 0) {
                for (Item item : items) {
                    System.out.println("---------------Заявки найдены---------------");
                    System.out.println("Имя: " + item.getName() + " Описание: " + item.getDesc() + " Время: " + item.getTime());
                }
            } else {
                System.out.println("---------------Заявки не найдены---------------");
            }
        }

        @Override
        public String info() {
            return key() + ". Find items by name";
        }
    }

    private static class ExitProgram implements UserAction {
        private static final int EXIT = 6;

        @Override
        public int key() {
            return EXIT;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }

        @Override
        public String info() {
            return key() + ". Exit program";
        }
    }
}
