package ru.job4j.tictactoe;

import ru.job4j.tictactoe.Figure3T;

import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinner(Predicate<Figure3T> hasMark) {
        return this.fillBy(hasMark, 0, 0, 1, 0)
                || this.fillBy(hasMark, 1, 0,  0, 1)
                || this.fillBy(hasMark, 2, 0, 0, 1)
                || this.fillBy(hasMark, 0, 1, 1, 0)
                || this.fillBy(hasMark, 0, 2, 1, 0)
                || this.fillBy(hasMark, 0, 0, 0, 1)
                || this.fillBy(hasMark, 0, 0, 1, 1)
                || this.fillBy(hasMark, this.table.length - 1, 0, -1, 1);
    }

    public boolean isWinnerO() {
        return isWinner(Figure3T::hasMarkO);
    }

    public boolean isWinnerX() {
        return isWinner(Figure3T::hasMarkX);
    }

    public boolean hasGap() {
        var result = false;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (!table[i][j].hasMarkO() && !table[i][j].hasMarkX()) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}