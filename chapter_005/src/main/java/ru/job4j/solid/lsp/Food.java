package ru.job4j.solid.lsp;

import org.joda.time.LocalDate;

public class Food {
    private String name;
    private LocalDate createDate;
    private LocalDate expairDate;
    private double price;
    private double discount;

    public Food(String name, LocalDate create, LocalDate expair, double price, double discount) {
        this.name = name;
        this.createDate = create;
        this.expairDate = expair;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getExpairDate() {
        return expairDate;
    }

    public double getDiscount() {
        return discount;
    }

    public double getPrice() {
        return price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", createDate=" + createDate
                + ", expairDate=" + expairDate
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }
}



