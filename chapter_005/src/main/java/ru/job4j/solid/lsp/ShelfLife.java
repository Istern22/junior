package ru.job4j.solid.lsp;

import org.joda.time.Days;
import org.joda.time.LocalDate;

public class ShelfLife {
    public Double getCurrent(Food food) {
        double allLife = Days.daysBetween(food.getCreateDate(), food.getExpairDate()).getDays();
        double wastedLife = Days.daysBetween(food.getCreateDate(), LocalDate.now()).getDays();
        return wastedLife / allLife;
    }
}
