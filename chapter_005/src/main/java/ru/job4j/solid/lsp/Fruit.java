package ru.job4j.solid.lsp;

import org.joda.time.LocalDate;

public class Fruit extends Food {
    public Fruit(String name, LocalDate create, LocalDate expair, double price, double discount) {
        super(name, create, expair, price, discount);
    }
}
