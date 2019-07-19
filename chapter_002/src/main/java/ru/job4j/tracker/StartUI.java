package ru.job4j.tracker;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа для вывода всех заявок.
     */
    private static final String SHOW_ALL = "1";

    /**
     * Константа для редактирования заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа для удаления заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа для поиска заявки по id.
     */
    private static final String FIND_BY_ID = "4";

    /**
     * Константа для поиска заявки по имени.
     */
    private static final String FIND_BY_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструктор инициализирующий поля.
     * @param input ввод данных;
     * @param tracker хранилище заявок;
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основной цикл программы.
     */
    public void init() {
        boolean exit = false;
        while(!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню:");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findItemById();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("---------------Добавление новой заявки---------------");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        Item item = new Item(name, desc, 1L);
        this.tracker.add(item);
        System.out.println("---------------Новая заявка с getId: " + item.getId() + "---------------");
    }

    /**
     * Метод показывает все существующие заявки.
     */
    private void showAllItems() {
        System.out.println("---------------Все существующие заявки---------------" + this.tracker.findAll());
    }

    /**
     * Метод редактирует заявку.
     */
    private void editItem() {
        System.out.println("---------------Редактирование заявки---------------");
        String id = this.input.ask ("Введите id заявки, которую нужно отредактировать");
        System.out.println("Ваша заявка: " + this.tracker.findById(id));
        String name = this.input.ask("Отредактируйте имя заявки: ");
        String desc = this.input.ask("Отредактируйте описание заявки: ");
        Item item = new Item(name, desc, 1L);
        this.tracker.replace(id, item);
        System.out.println("---------------Заявка отредактирована---------------");
    }

    /**
     * Метод удаляет заявку
     */
    private void deleteItem() {
        System.out.println("---------------Удаление заявки---------------");
        String id = this.input.ask ("Введите id заявки, которую нужно удалить");
        this.tracker.delete(id);
        System.out.println("---------------Заявка удалена---------------");
    }

    /**
     * Метод находит заявку по id.
     */
    private void findItemById() {
        System.out.println("---------------Поиск заявки по id---------------");
        String id = this.input.ask ("Введите id заявки, которую нужно найти");
        System.out.println(this.tracker.findById(id));
        System.out.println("---------------Заявка найдена---------------");
    }

    /**
     * Метода находит заявку по имени.
     */
    private void findItemByName() {
        System.out.println("---------------Поиск заявки по имени---------------");
        String name = this.input.ask ("Введите имя заявки, которую нужно найти");
        System.out.println(this.tracker.findByName(name));
        System.out.println("---------------Заявка найдена---------------");
    }

    private void showMenu() {
        System.out.println("Меню:");
        System.out.println("0. Add new item");
        System.out.println("1. Show all item");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit program");
    }

    /**
     * Запуск программы
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
