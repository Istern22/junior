package ru.job4j.profession;

public class Surgeon extends Doctor {
    private Organ organ;
    private Operation operation;

    public Surgeon(String name, String surname, String education, long birthday) {
        super(name, surname, education, birthday);
    }

    public Operation treat(Operation operation, Organ organ) {
        return operation;
    }
}
