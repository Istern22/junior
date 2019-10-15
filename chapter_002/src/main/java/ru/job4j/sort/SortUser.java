package ru.job4j.sort;

import java.util.*;

public class SortUser {

    public Set<User> sort(List<User> list) {
        AgeComparator ageComparator = new AgeComparator();
        Set<User> users = new TreeSet<>(ageComparator);
        for (User user : list) {
            users.add(user);
        }
        return users;
    }

    public List<User> sortNameLength(List<User> list) {
        LengthComparator lengthComparator = new LengthComparator();
        List<User> users = new ArrayList<>();
        for (User user : list) {
            users.add(user);
        }
        users.sort(lengthComparator);
        return users;
    }

    public List<User> sortByAllFields(List<User> list) {
        NameAgeComparator nameAgeComparator = new NameAgeComparator();
        List<User> users = new ArrayList<>();
        for (User user : list) {
            users.add(user);
        }
        users.sort(nameAgeComparator);
        return users;
    }
}