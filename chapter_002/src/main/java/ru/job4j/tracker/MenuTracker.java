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
        this.actions.add(new AddItem(0, "Add item"));
        this.actions.add(new ShowItems(1, "Show items"));
        this.actions.add(new UpdateItem(2, "Update item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit program"));
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
        public void execute(Input input, Tracker tracker) {
            System.out.println("----------ADD ITEM----------");
            String name = input.ask("Enter item name: ");
            String desc = input.ask("Enter item description: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println(String.format("New item id: %s | name: %s | description: %s",
                    item.getId(), item.getName(), item.getDesc()));
        }
    }

    private static class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("----------ALL ITEMS----------");
            Item[] items = tracker.findAll();
            for (Item item : items) {
                System.out.println(String.format("Item id: %s | name: %s | description: %s",
                        item.getId(), item.getName(), item.getDesc()));
            }
        }
    }

    private static class UpdateItem extends BaseAction {

        public UpdateItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("----------UPDATE ITEM----------");
            String id = input.ask("Enter item id");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(String.format("Item name: %s | description: %s",
                        item.getName(), item.getDesc()));
                String name = input.ask("Enter new name: ");
                String desc = input.ask("Enter new description: ");
                Item newItem = new Item(name, desc);
                newItem.setId(id);
                tracker.replace(id, newItem);
                System.out.println(String.format("Updated item id: %s | name: %s | description: %s",
                        item.getId(), item.getName(), item.getDesc()));
            } else {
                System.out.println("Item doesn't exist");
            }
        }
    }

    private static class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("----------DELETE ITEM----------");
            String id = input.ask("Enter item id");
            if (tracker.delete(id)) {
                System.out.println("Item deleted");
            } else {
                System.out.println("Item doesn't exist");
            }
        }
    }

    private static class FindItemById extends BaseAction {

        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("----------FIND ITEM BY ID----------");
            String id = input.ask("Enter item id");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(String.format("Required item id: %s | name: %s | description: %s",
                        item.getId(), item.getName(), item.getDesc()));
            } else {
                System.out.println("Item doesn't exist");
            }
        }
    }

    private static class FindItemsByName extends BaseAction {

        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("----------FIND ITEM BY NAME----------");
            String name = input.ask("Enter item name");
            Item[] items = tracker.findByName(name);
            if (items.length != 0) {
                for (Item item : items) {
                    System.out.println(String.format("Required item id: %s | name: %s | description: %s",
                            item.getId(), item.getName(), item.getDesc()));
                }
            } else {
                System.out.println("Item doesn't exist");
            }
        }
    }

    private static class ExitProgram extends BaseAction {

        public ExitProgram(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }
    }
}
