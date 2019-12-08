package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profile {

    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        return this.address.equals(((Profile) o).getAddress());
    }

    public int hashCode() {
        return this.address.hashCode();
    }
}
