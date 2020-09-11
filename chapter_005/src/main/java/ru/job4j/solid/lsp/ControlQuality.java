package ru.job4j.solid.lsp;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControlQuality {

    Shop shop = new Shop();
    Warehouse warehouse = new Warehouse();
    Trash trash = new Trash();

    private List<Store> storage = Arrays.asList(shop, warehouse, trash);

    public void execute(Food food) {
        for (Store store : storage) {
            if (store.accept(food)) {
                store.add(food);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Food apple = new Fruit("apple", new LocalDate("2020-09-01"), new LocalDate("2020-10-30"), 100.0, 0.0);
        Food bread = new Bakery("bread", new LocalDate("2020-09-01"), new LocalDate("2020-09-30"), 100.0, 0.0);
        Food orange = new Fruit("orange", new LocalDate("2020-09-01"), new LocalDate("2020-09-11"), 100.0, 0.0);
        Food cake = new Bakery("cake", new LocalDate("2020-09-01"), new LocalDate("2020-09-08"), 100.0, 0.0);
        Food bagel = new Bakery("bagel", new LocalDate("2020-09-01"), new LocalDate("2020-09-06"), 100.0, 0.0);
        List<Food> input = Arrays.asList(apple, bread, orange, cake, bagel);
        ControlQuality controlQuality = new ControlQuality();
        for (Food food : input) {
            controlQuality.execute(food);
        }
    }
}
