package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
    private Store tracker;

    private final Consumer<String> output;

    /**
     * @param хранит ссылку на массив типа UserAction
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     * @param output вывод
     */
    public MenuTracker(Input input, Store tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
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
        this.actions.add(new AddItem(0, "Add item"));
        this.actions.add(new ShowItems(1, "Show items"));
        this.actions.add(new UpdateItem(2, "Update item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit program"));
    }

    /**
     * В зависимости от указанного ключа, метод выполняет соответсвтующие действия
     *
     * @param key ключ операции
     */
    public void select(int key) throws SQLException {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню
     */
    public void show() {
        System.out.println("MENU");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Store tracker) {
            System.out.println("----------ADD ITEM----------");
            System.lineSeparator();
            String name = input.ask("Enter item name: ");
            String desc = input.ask("Enter item description: ");
            Item item = new Item(name, desc);
            try {
                tracker.add(item);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            output.accept(String.format("New item id: %s | name: %s | description: %s",
                    item.getId(), item.getName(), item.getDesc()));
            System.lineSeparator();
        }
    }

    class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Store tracker) {
            System.out.println("----------ALL ITEMS----------");
            List<Item> items = null;
            try {
                items = tracker.findAll();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            for (Item item : items) {
                output.accept(String.format("Item id: %s | name: %s | description: %s",
                        item.getId(), item.getName(), item.getDesc()));
            }
        }
    }

    class UpdateItem extends BaseAction {

        public UpdateItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Store tracker) {
            System.out.println("----------UPDATE ITEM----------");
            String id = input.ask("Enter item id");
            Item item = null;
            try {
                item = tracker.findById(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (item != null) {
                output.accept(String.format("Item name: %s | description: %s",
                        item.getName(), item.getDesc()));
                System.lineSeparator();
                String name = input.ask("Enter new name: ");
                String desc = input.ask("Enter new description: ");
                Item newItem = new Item(name, desc);
                newItem.setId(id);
                try {
                    tracker.replace(id, newItem);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                output.accept(String.format("Updated item id: %s | name: %s | description: %s",
                        item.getId(), newItem.getName(), newItem.getDesc()));
                System.lineSeparator();
            } else {
                output.accept("Item doesn't exist");
                System.lineSeparator();
            }
        }
    }

    class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Store tracker) {
            System.out.println("----------DELETE ITEM----------");
            String id = input.ask("Enter item id");
            try {
                if (tracker.delete(id)) {
                    output.accept("Item deleted");
                    System.lineSeparator();
                } else {
                    output.accept("Item doesn't exist");
                    System.lineSeparator();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    class FindItemById extends BaseAction {

        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Store tracker) {
            System.out.println("----------FIND ITEM BY ID----------");
            System.lineSeparator();
            String id = input.ask("Enter item id");
            Item item = null;
            try {
                item = tracker.findById(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (item != null) {
                output.accept(String.format("Required item id: %s | name: %s | description: %s",
                        item.getId(), item.getName(), item.getDesc()));
                System.lineSeparator();
            } else {
                output.accept("Item doesn't exist");
                System.lineSeparator();
            }
        }
    }

    class FindItemsByName extends BaseAction {

        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Store tracker) {
            System.out.println("----------FIND ITEM BY NAME----------");
            System.lineSeparator();
            String name = input.ask("Enter item name");
            List<Item> items = null;
            try {
                items = tracker.findByName(name);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (items.size() != 0) {
                for (Item item : items) {
                    output.accept(String.format("Required item id: %s | name: %s | description: %s",
                            item.getId(), item.getName(), item.getDesc()));
                    System.lineSeparator();
                }
            } else {
                output.accept("Item doesn't exist");
                System.lineSeparator();
            }
        }
    }

    class ExitProgram extends BaseAction {

        public ExitProgram(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Store tracker) {

        }
    }
}
