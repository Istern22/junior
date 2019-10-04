package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrixToList {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] values : array) {
            for (int value : values) {
                list.add(value);
            }
        }
        return list;
    }
}
