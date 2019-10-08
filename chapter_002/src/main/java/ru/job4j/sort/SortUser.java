package ru.job4j.sort;

import java.util.*;

public class SortUser {

    public Set<User> sort(List<User> list){
        UserComparator ageComparator = new UserComparator();
        Set<User> users = new TreeSet<>(ageComparator);
        for (User user : list) {
            users.add(user);
        }
        return users;
    }
}