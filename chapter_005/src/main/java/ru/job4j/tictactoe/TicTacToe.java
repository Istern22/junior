package ru.job4j.tictactoe;

public class TicTacToe {

    Desk desk;
    int x = 0;
    int o = 0;
    int winnerX = 0;
    int winnerO = 0;

    public TicTacToe() {
        desk = new Desk3х3();
    }

    public void go() {
        Input in = new Input();
        fill(in.ask("Введите координаты: "));
        desk.print();
    }

    public void check() {
        for (int i = 0; i < desk.getSize(); i++) {
            if (x == 1) {
            }
        }
    }

    public void fill(String xy) {
        int a = Integer.parseInt(xy.split("")[0]);
        int b = Integer.parseInt(xy.split("")[1]);
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

    public static void main(String[] args) {
        Desk desk = new Desk3х3();
        TicTacToe ticTacToe = new TicTacToe();
        desk.print();
        int x = 0;
        while (x != 9) {
            ticTacToe.go();
            x++;
        }
    }
}
