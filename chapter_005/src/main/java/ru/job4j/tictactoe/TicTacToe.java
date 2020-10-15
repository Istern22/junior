package ru.job4j.tictactoe;

public class TicTacToe {
    public Desk desk;
    int x = 0;
    int o = 0;
    String winnerMark;

    public TicTacToe(int size) {
        desk = new Desk(size);
    }

    public void go() {
        Input in = new Input();
        desk.print();
        String coordinates = in.ask("Введите координаты: ");
        int x = Integer.parseInt(coordinates.split("")[0]);
        int y = Integer.parseInt(coordinates.split("")[1]);
        if (desk.getDesk()[x][y] != null) {
            System.out.println("Неверные координаты");
            go();
        } else {
            fill(x, y);
        }
    }

    public void randomGo() {
        int i;
        int j;
        do {
            i = (int) (Math.random() * 3);
            j = (int) (Math.random() * 3);
        } while (desk.getDesk()[i][j] == "•");
        if (x == 0) {
            desk.getDesk()[i][j] = "x";
        } else {
            desk.getDesk()[i][j] = "0";
        }
    }

    public boolean checkDiagonal() {
        boolean result = true;
        String mark = "";
        for (int i = 1; i < desk.getSize() && result; i++) {
            result = desk.getDesk()[i][i] == desk.getDesk()[0][0]
                    && desk.getDesk()[i][i] != null;
            mark = desk.getDesk()[i][i];
        }
        if (!result) {
            for (int i = 1; i < desk.getSize() && result; i++) {
                result = desk.getDesk()[desk.getSize() - i - 1][i] == desk.getDesk()[desk.getSize() - 1][0]
                        && desk.getDesk()[desk.getSize() - i - 1][i] != null;
                mark = desk.getDesk()[desk.getSize() - i - 1][i];
            }
        }
        winnerMark = mark;
        return result;
    }

    public boolean checkHorizontal() {
        String mark = "";
        for (int i = 0; i < desk.getSize(); i++) {
            boolean result = true;
            for (int j = 1; j < desk.getSize() && result; j++) {
                result = desk.getDesk()[i][j] == desk.getDesk()[i][0] && desk.getDesk()[i][0] != null;
                mark = desk.getDesk()[i][j];
            }
            if (result) {
                winnerMark = mark;
                return true;
            }
        }
        return false;
    }

    public boolean checkVertical() {
        String mark = "";
        for (int j = 0; j < desk.getSize(); j++) {
            boolean result = true;
            for (int i = 1; i < desk.getSize() && result; i++) {
                result = desk.getDesk()[i][j] == desk.getDesk()[0][j] && desk.getDesk()[0][j] != null;
                mark = desk.getDesk()[i][j];
            }
            if (result) {
                winnerMark = mark;
                return true;
            }
        }
        return false;
    }

    public void fill(int a, int b) {
        if (x == 0 && o == 0) {
            desk.getDesk()[a][b] = "x";
            x++;
        } else if (x == 0 && o == 1) {
            desk.getDesk()[a][b] = "x";
            x++;
            o--;
        } else if (x == 1 && o == 0) {
            desk.getDesk()[a][b] = "0";
            x--;
            o++;
        }
    }

    public boolean isWinner() {
        return checkDiagonal() || checkHorizontal() || checkVertical();
    }


    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3);
        int winnerX = 0;
        int winnerO = 0;
        String winner = "";
        while (true) {
            ticTacToe.go();
            if (ticTacToe.isWinner()) {
                if (ticTacToe.winnerMark == "x") {
                    winnerX++;
                } else if (ticTacToe.winnerMark == "0") {
                    winnerO++;
                }
                ticTacToe.desk.print();
                winner = ticTacToe.winnerMark;
                System.out.println("Следующая игра:");
                ticTacToe = new TicTacToe(3);
            }
            if (winnerO == 2 || winnerX == 2) {
                System.out.println("Победил игрок " + winner);
                System.out.println("Игра окончена!");
                break;
            }
        }
    }
}
