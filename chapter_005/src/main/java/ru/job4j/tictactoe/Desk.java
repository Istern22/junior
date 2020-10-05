package ru.job4j.tictactoe;

public abstract class Desk {

    private int size;
    private String[][] desk;

    public Desk(int size) {
        this.size = size;
        desk = new String[size][size];
    }

     public void print() {
         System.out.print("y/x ");
         for (int i = 0; i < size; i++) {
             System.out.print(i);
             System.out.print("  ");
         }
         System.out.println();
         for (int i = 0; i < size; i++) {
             System.out.print(" " + i + " ");
             for (int j = 0; j < size; j++) {
                 System.out.print(" " + (desk[i][j] == null ? "•" : desk[i][j]) + " ");
             }
             System.out.println();
         }
     }

    public int getSize() {
        return size;
    }

    public String[][] getDesk() {
        return desk;
    }
}
