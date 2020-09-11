package ru.job4j.solid.lsp;

import java.util.ArrayList;

public class Warehouse implements Store {
    private ArrayList<Food> store = new ArrayList<>();

    public ArrayList<Food> getStore() {
        return store;
    }

    @Override
    public boolean accept(Food food) {
        return new ShelfLife().getCurrent(food) < 0.25;
    }

    @Override
    public void add(Food food) {
        store.add(food);
        System.out.println("Put in the warehouse!");
    }
}
