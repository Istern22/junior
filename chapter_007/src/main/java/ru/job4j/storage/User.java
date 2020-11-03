package ru.job4j.storage;

import java.util.Objects;

public class User {
    private int id;
    private int amount;

    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return getId() == user.getId()
                && getAmount() == user.getAmount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAmount());
    }
}
