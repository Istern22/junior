package ru.job4j.profession;

public class Surgeon extends Doctor {
    private Organ organ;
    private Operation operation;

    public Operation treat(Operation operation, Organ organ){
        return operation;
    }
}
