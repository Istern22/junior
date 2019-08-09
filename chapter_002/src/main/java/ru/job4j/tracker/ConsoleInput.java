package ru.job4j.tracker;

import java.util.Scanner;
import java.util.List;

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        if (!range.contains(key)) {
            throw new MenuOutException("Out of menu range.");
        }
        return key;
    }
}
