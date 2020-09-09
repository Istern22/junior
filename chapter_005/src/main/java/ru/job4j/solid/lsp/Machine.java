package ru.job4j.solid.lsp;

public class Machine {

    private String name;

    private String number;

    private Integer size;

    public Machine(String name, String number, Integer size) {
        this.name = name;
        this.number = number;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public Integer getSize() {
        return size;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Machine{"
                + "name='" + name + '\''
                + ", number='" + number + '\''
                + ", size=" + size
                + '}';
    }
}
