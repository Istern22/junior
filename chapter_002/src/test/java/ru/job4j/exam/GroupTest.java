package ru.job4j.exam;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;

public class GroupTest {

    public static List<Student> students = List.of(
            new Student("Anna", Set.of("swimming", "painting", "programming")),
            new Student("Aleksandr", Set.of("swimming", "football", "boxing")),
            new Student("Petr", Set.of("programming")),
            new Student("Michail", Set.of("football", "boxing")),
            new Student("Vera", Set.of("painting", "programming")),
            new Student("Anton", Set.of("boxing", "painting"))
    );

    @Test
    public void whenSection() {
        Group group = new Group();
        Map<String, Set<String>> sections = Map.of(
                "swimming", Set.of("Aleksandr", "Anna"),
                "painting", Set.of("Anton", "Vera", "Anna"),
                "boxing", Set.of("Aleksandr", "Anton", "Michail"),
                "football", Set.of("Aleksandr", "Michail"),
                "programming", Set.of("Petr", "Vera", "Anna")
        );
        Assert.assertThat(group.sections(students), is(sections));
    }
}
