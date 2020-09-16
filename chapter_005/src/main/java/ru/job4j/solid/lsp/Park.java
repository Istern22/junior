package ru.job4j.solid.lsp;

public interface Park {
    boolean accept(Machine machine);
    void park(Machine machine);
}
