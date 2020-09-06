package ru.job4j.solid.lsp;

public interface Store {
    boolean accept(Food food);
    void add(Food food);
}
