package ru.job4j.sort;

import org.junit.Test;

import java.util.*;

import static  org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void ageComparing() {
        SortUser users = new SortUser();
        List<User> list = List.of(
                new User("anna", 2),
                new User("ivan", 1)
        );
        Set<User> sortUser = users.sort(list);
        assertThat(sortUser.iterator().next().getName(), is("ivan"));
    }

    @Test
    public void nameLengthComparing() {
        SortUser users = new SortUser();
        List<User> list = List.of(
                new User("anna", 2),
                new User("eva", 1),
                new User("aleksandr", 5)
        );
        List<User> sortUser = users.sortNameLength(list);
        assertThat(sortUser.iterator().next().getName(), is("eva"));
    }

    @Test
    public void nameAgeComparing() {
        SortUser users = new SortUser();
        List<User> list = List.of(
                new User("anna", 2),
                new User("anna", 4),
                new User("eva", 1),
                new User("aleksandr", 5),
                new User("aleksandr", 3)
        );
        List<User> sortUser = users.sortByAllFields(list);
        assertThat(sortUser.iterator().next().getAge(), is(3));
    }
}

