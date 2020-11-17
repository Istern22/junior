package ru.job4j.pool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RowColSum {

    public static class Sums {
        private int rowSum;
        private int colSum;

        public int getColSum() {
            return colSum;
        }

        public int getRowSum() {
            return rowSum;
        }

        public void setColSum(int colSum) {
            this.colSum = colSum;
        }

        public void setRowSum(int rowSum) {
            this.rowSum = rowSum;
        }
    }

    public static Sums[] sum(int[][] matrix) {
        int n = matrix.length;
        Sums[] sums = new Sums[n];
        for (int t = 0; t < n; t++) {
            sums[t] = new Sums();
        }
        int row = 0;
        int column = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row = row + matrix[i][j];
                column = column + matrix[j][i];
                if (j == n - 1) {
                    sums[i].setRowSum(row);
                    row = 0;
                    sums[i].setColSum(column);
                    column = 0;
                }
            }
        }
        return sums;
    }

    public static Sums[] asyncSum(int[][] matrix) throws ExecutionException, InterruptedException {
        int n = matrix.length;
        Sums[] sums = new Sums[n];
        for (int t = 0; t < n; t++) {
            sums[t] = new Sums();
        }
        Map<Integer, CompletableFuture<Integer>> resultRow = new HashMap<>();
        Map<Integer, CompletableFuture<Integer>> resultCol = new HashMap<>();
        for (int i = 0; i < n; i++) {
            resultRow.put(i, getTask(matrix, i, i, n - 1));
            resultCol.put(i, getTask(matrix, 0, n - 1, i));
        }
        for (int k = 0; k < n; k++) {
            sums[k].setRowSum(resultRow.get(k).get());
            sums[k].setColSum(resultCol.get(k).get());
        }
        return sums;
    }

    public static  CompletableFuture<Integer> getTask(int[][] matrix, int startRow, int endRow, int endCol) {
        return CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            if (startRow == endRow) {
                for (int j = 0; j <= endCol; j++) {
                    sum = sum + matrix[startRow][j];
                }
            } else {
                for (int i = 0; i <= endRow; i++) {
                    sum = sum + matrix[i][endCol];
                }
            }
            return sum;
        });
    }
}
