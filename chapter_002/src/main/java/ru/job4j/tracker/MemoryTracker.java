package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class MemoryTracker {

    private ArrayList<Item> items = new ArrayList<>();
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (item.getId().equals(id)) {
                items.set(i, item);
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    public ArrayList<Item> findAll() {
        return items;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> names = new ArrayList<>();
        for (Item item : items) {
                if (item.getName().equals(key)) {
                    names.add(item);
            }
        }
        return names;
    }


    public Item findById(String id) {
        Item itemId = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                itemId = item;
                break;
            }
        }
        return itemId;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
