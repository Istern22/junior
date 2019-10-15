package ru.job4j.sort;

import java.util.Comparator;

public class NameAgeComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        int result = o1.getName().compareTo(o2.getName());
        return result != 0 ? result : Integer.compare(o1.getAge(), o2.getAge());
    }
}
