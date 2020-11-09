package ru.job4j.cache;

public class OptimisticException extends RuntimeException {
    public OptimisticException() {
        super("The version was updated!");
    }
}
