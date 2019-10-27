package ru.job4j.bank;

import java.util.Objects;

public class User implements Comparable<User> {

    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return this.passport.equals(user.getPassport());
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    @Override
    public int compareTo(User o) {
        return this.passport.compareTo(o.getPassport());
    }
}
