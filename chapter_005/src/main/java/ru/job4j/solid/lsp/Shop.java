package ru.job4j.solid.lsp;

import java.util.ArrayList;

public class Shop implements Store {
    private ArrayList<Food> store = new ArrayList<>();

    public ArrayList<Food> getStore() {
        return store;
    }

    @Override
    public boolean accept(Food food) {
        double shelfLife = new ShelfLife().getCurrent(food);
        return shelfLife >= 0.25 && shelfLife < 1.0;
    }

    @Override
    public void add(Food food) {
        if (new ShelfLife().getCurrent(food) > 0.75) {
            food.setDiscount(0.5);
        }
        store.add(food);
        System.out.println("Put in the shop!");
    }
}
