package ru.job4j.tracker;

import java.util.Objects;
import java.util.Random;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод, реализующий добавления заявки в хранилище
     * Метод добавляет заявку, переданную в аргументах в массив заявок this.items;
     * В методе add нужно проставить уникальный ключ в объект Item item.
     * Уникальный ключ нужно генерировать на основании времени и произвольного числа.     *
     * item.setId(this.generateId());
     * В качестве ключа нельзя использовать индекс.
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод должен заменить ячейку в массиве this.items.
     * Для этого необходимо найти ячейку в массиве по id.
     * Метод должен вернуть boolean результат - удалось ли провести операцию.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод должен удалить ячейку в массиве this.items.
     * Для этого необходимо найти ячейку в массиве по id.
     * Далее сместить все значения справа от удаляемого элемента -
     * на одну ячейку влево с помощью System.arrayCopy().
     * Метод должен вернуть boolean результат - удалось ли провести операцию.
     */
    public boolean delete(String id) {
        boolean result = false;
        int location = 0;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                location = i;
                result = true;
                System.arraycopy(this.items, location + 1, this.items, location, this.items.length - location - 1);
                position--;
                break;
            }
        }
        return result;
    }

    /**
     * Метод возвращает копию массива this.items без null элементов
     */
    public Item[] findAll() {
        Item[] items1 = new Item[position];
        System.arraycopy(this.items, 0, items1, 0, position);
        return items1;
    }

    /**
     *  Метод проверяет в цикле все элементы массива this.items,
     *  сравнивая name (используя метод getName класса Item) с аргументом метода String key.
     *  Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его;
     */
    public Item[] findByName(String key) {
        Item[] names = new Item[position];
        int j = 0;
        for (int i = 0; i < position; i++) {
                if (this.items[i].getName().equals(key)) {
                    names[j] = this.items[i];
                    j++;
            }
        }
        Item[] result = new Item[j];
        System.arraycopy(names, 0, result, 0, j);
        return result;
    }

    /**
     * Метод проверяет в цикле все элементы массива this.items,
     * сравнивая id с аргументом String id и возвращает найденный Item.
     * Если Item не найден - возвращает null.
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                result = this.items[i];
                break;
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описания,
     * для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
