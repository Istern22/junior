package ru.job4j.list;

import java.util.List;

public class ConvertListToArray {
    public int[][] toArray(List<Integer> list, int rows) {
        int size = list.size();
        int columns = size % rows == 0 ? size / rows : size / rows + 1;
        int[][] array = new int[rows][columns];
        int row = 0;
        int column = 0;
        for (int value : list) {
            array[row][column] = value;
            column++;
            if (column > columns - 1) {
                row++;
                column = 0;
            }
        }
        return array;
    }
}
