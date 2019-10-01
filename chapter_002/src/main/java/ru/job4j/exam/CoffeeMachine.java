package ru.job4j.exam;

import java.util.ArrayList;

public class CoffeeMachine {
    public static final int[] COINS = {10, 5, 2, 1};
    int[] changes(int value, int price) {
        int change = value - price;
        ArrayList<Integer> changes = new ArrayList<>();
        for (int i = 0; i < COINS.length; i++) {
            int amount = (int) change / COINS[i];
            for (int j = 0; j < amount; j++) {
                changes.add(COINS[i]);
            }
            change = change - amount * COINS[i];
        }
        int[] changesArray = new int[changes.size()];
        for (int i = 0; i < changes.size(); i++) {
           changesArray[i] = changes.get(i);
        }
        return changesArray;
    }
}
