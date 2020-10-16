package ru.job4j.solid.isp;

import java.util.Iterator;
import java.util.Scanner;

public class MenuAction {

    private Scanner scanner = new Scanner(System.in);
    private Menu menu = new Menu();

    public void ask() {
        System.out.println("Введите пункт меню");
        Menu.Item item = menu.find(scanner.nextLine());
        item.getAction();
    }
}
