package ru.job4j.collections.exam;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StoreTest {
    @Test
    public void whenMergeTwoUsers() {
        var store = new Store();
        var map = Map.of(
                new User("user0"), new HashSet<>(Set.of("0@mail.ru", "1@mail.ru", "2@mail.ru")),
                new User("user1"), new HashSet<>(Set.of("0@mail.ru", "3@mail.ru")),
                new User("user2"), new HashSet<>(Set.of("4@mail.ru"))
        );
        var expected = new HashSet<HashSet<String>>();
        expected.add(new HashSet<>(Set.of("0@mail.ru", "1@mail.ru", "2@mail.ru", "3@mail.ru")));
        expected.add(new HashSet<>(Set.of("4@mail.ru")));
        assertThat(store.merge(map).values().stream().collect(Collectors.toSet()), is(expected));
    }

    @Test
    public void whenNoMergeUsers() {
        var store = new Store();
        var map = Map.of(
                new User("user0"), new HashSet<>(Set.of("0@mail.ru", "1@mail.ru")),
                new User("user1"), new HashSet<>(Set.of("2@mail.ru", "3@mail.ru")),
                new User("user2"), new HashSet<>(Set.of("4@mail.ru", "5@mail.ru"))
        );
        assertThat(store.merge(map), is(Map.of(
                new User("user0"), new HashSet<>(List.of("0@mail.ru", "1@mail.ru")),
                new User("user1"), new HashSet<>(List.of("2@mail.ru", "3@mail.ru")),
                new User("user2"), new HashSet<>(List.of("4@mail.ru", "5@mail.ru"))
        )));
    }

    @Test
    public void whenMergeAllUsersInOne() {
        var store = new Store();
        var map = Map.of(
                new User("user0"), new HashSet<>(Set.of("0@mail.ru", "1@mail.ru")),
                new User("user1"), new HashSet<>(Set.of("1@mail.ru", "2@mail.ru")),
                new User("user2"), new HashSet<>(Set.of("1@mail.ru", "3@mail.ru"))
        );
        var expected = new HashSet<HashSet<String>>();
        expected.add(new HashSet<>(Set.of("0@mail.ru", "1@mail.ru", "2@mail.ru", "3@mail.ru")));
        assertThat(store.merge(map).values().stream().collect(Collectors.toSet()), is(expected));
    }

    @Test
    public void whenMergeSixUsersInTwo() {
        var store = new Store();
        var map = Map.of(
                new User("user0"), new HashSet<>(Set.of("0@mail.ru", "1@mail.ru")),
                new User("user1"), new HashSet<>(Set.of("1@mail.ru", "2@mail.ru")),
                new User("user3"), new HashSet<>(Set.of("4@mail.ru", "5@mail.ru")),
                new User("user5"), new HashSet<>(Set.of("5@mail.ru", "6@mail.ru"))
        );
        var expected = new HashSet<HashSet<String>>();
        expected.add(new HashSet<>(Set.of("0@mail.ru", "1@mail.ru", "2@mail.ru")));
        expected.add(new HashSet<>(Set.of("4@mail.ru", "5@mail.ru", "6@mail.ru")));
        assertThat(store.merge(map).values().stream().collect(Collectors.toSet()), is(expected));
    }

    @Test
    public void whenMergeAllUsersInTwo() {
        var store = new Store();
        var map = Map.of(
                new User("user0"), new HashSet<>(Set.of("0@mail.ru", "1@mail.ru")),
                new User("user1"), new HashSet<>(Set.of("1@mail.ru", "2@mail.ru")),
                new User("user2"), new HashSet<>(Set.of("2@mail.ru", "1@mail.ru", "3@mail.ru")),
                new User("user3"), new HashSet<>(Set.of("4@mail.ru")),
                new User("user4"), new HashSet<>(Set.of("4@mail.ru", "5@mail.ru"))
        );
        var expected = new HashSet<HashSet<String>>();
        expected.add(new HashSet<>(Set.of("0@mail.ru", "1@mail.ru", "2@mail.ru", "3@mail.ru")));
        expected.add(new HashSet<>(Set.of("4@mail.ru", "5@mail.ru")));
        assertThat(store.merge(map).values().stream().collect(Collectors.toSet()), is(expected));
    }
}