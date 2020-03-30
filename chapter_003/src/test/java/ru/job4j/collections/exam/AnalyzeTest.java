package ru.job4j.collections.exam;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AnalyzeTest {
    @Test
    public void whenAnalyzeOnlyChanged() {
        var analyze = new Analyze();
        var previous = List.of(
                new Analyze.User(000, "user0"),
                new Analyze.User(001, "user1"),
                new Analyze.User(002, "user2")
        );
        var current = List.of(
                new Analyze.User(000, "user0"),
                new Analyze.User(001, "user11"),
                new Analyze.User(002, "user22")
        );
        assertThat(analyze.difference(previous, current), is(new Analyze.Info(0, 2, 0)));
    }

    @Test
    public void whenAnalyzeOnlyDeleted() {
        var analyze = new Analyze();
        var previous = List.of(
                new Analyze.User(000, "user0"),
                new Analyze.User(001, "user1"),
                new Analyze.User(002, "user2")
        );
        var current = new ArrayList<Analyze.User>();
        assertThat(analyze.difference(previous, current), is(new Analyze.Info(0, 0, 3)));
    }

    @Test
    public void whenAnalyzeOnlyAdded() {
        var analyze = new Analyze();
        var previous = List.of(
                new Analyze.User(000, "user0")
        );
        var current = List.of(
                new Analyze.User(000, "user0"),
                new Analyze.User(001, "user1"),
                new Analyze.User(002, "user2")
        );
        assertThat(analyze.difference(previous, current), is(new Analyze.Info(2, 0, 0)));
    }

    @Test
    public void whenMixOfAll() {
        var analyze = new Analyze();
        var previous = List.of(
                new Analyze.User(000, "user0"),
                new Analyze.User(001, "user1"),
                new Analyze.User(002, "user2"),
                new Analyze.User(003, "user3"),
                new Analyze.User(004, "user4")

        );
        var current = List.of(
                new Analyze.User(000, "user00"),
                new Analyze.User(001, "user1"),
                new Analyze.User(002, "user22"),
                new Analyze.User(005, "user5"),
                new Analyze.User(006, "user6")
        );
        assertThat(analyze.difference(previous, current), is(new Analyze.Info(2, 2, 2)));
    }
}