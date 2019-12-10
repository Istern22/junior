package ru.job4j.stream;

public class Address {

    private String city;
    private String street;
    private int home;
    private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        return this.toString().equals(((Address) o).toString());
    }

    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public String toString() {
        return "Address{"
                + "city='" + city + '\''
                + "street='" + street + '\''
                + "home='" + home + '\''
                + "apartment='" + apartment + '\''
                + '}';
    }
}
