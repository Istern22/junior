package ru.job4j;

public class DCLSingleton {
    private static volatile DCLSingleton inst;

    public static DCLSingleton instOf() {
        synchronized (DCLSingleton.class) {
            if (inst == null) {
                inst = new DCLSingleton();
            }
            return inst;
        }
    }

    private DCLSingleton() {

    }
}
