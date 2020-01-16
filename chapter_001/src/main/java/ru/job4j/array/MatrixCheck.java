package ru.job4j.array;

public class MatrixCheck {

    public static boolean monoHorizontal(char[][] board, int row) {
        var result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != 'X') {
                result = false;
                break;
            }
        }
        return  result;
    }

    public static boolean monoVertical(char[][] board, int column) {
        var result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] != 'X') {
                result = false;
                break;
            }
        }
        return  result;
    }

    public static boolean isWin(char[][] board) {
        var result = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 'X' && (monoHorizontal(board, i) || monoVertical(board, i))) {
                result = true;
            }
        }
        return result;
    }
}
