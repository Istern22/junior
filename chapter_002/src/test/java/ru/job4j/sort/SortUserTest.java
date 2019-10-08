package ru.job4j.sort;

import org.junit.Test;

import java.util.*;

import static  org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenTwoUsers() {
        SortUser users = new SortUser();
        List<User> list = (new ArrayList<User>(Arrays.asList(
                new User("anna", 2),
                new User("ivan", 1)
        )));
        Set<User> sortUser = users.sort(list);
        assertThat(sortUser.iterator().next().getName(), is("ivan"));
    }
}

