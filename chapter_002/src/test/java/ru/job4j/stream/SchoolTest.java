package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static  org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    public final static List<Student> STUDENTS = List.of(
            new Student(75),
            new Student(20),
            new Student(60),
            new Student(10),
            new Student(100)
    );

    public final static List<Student> STUDENTS_2 = List.of(
            new Student("Petrov", 75),
            new Student("Petrova", 20),
            new Student("Ivanov", 60),
            new Student("Ivanova", 10),
            new Student("Ivanova", 10)
    );

    @Test
    public void whenRangeFrom70To100ThanClass10A() {
        School school = new School();
        List<Student> students = school.collect(STUDENTS, x -> x.getScore() >= 70 && x.getScore() <= 100);
        assertThat(students, is(List.of(
                new Student(75),
                new Student(100)
        )));
    }

    @Test
    public void whenRangeFrom50To70ThanClass10B() {
        School school = new School();
        List<Student> students = school.collect(STUDENTS, x -> x.getScore() >= 50 && x.getScore() < 70);
        assertThat(students, is(List.of(
                new Student(60)
        )));
    }

    @Test
    public void whenRangeFrom0To50ThanClass10C() {
        School school = new School();
        List<Student> students = school.collect(STUDENTS, x -> x.getScore() >= 0 && x.getScore() < 50);
        assertThat(students, is(List.of(
                new Student(20),
                new Student(10)
        )));
    }

    @Test
    public void whenConvertListToMap() {
        School school = new School();
        Map<String, Student> studentMap = Map.of(
                "Petrov", new Student("Petrov", 75),
                "Petrova", new Student("Petrova", 20),
                "Ivanov", new Student("Ivanov", 60),
                "Ivanova", new Student("Ivanova", 10)
        );
        assertThat(school.convert(STUDENTS_2), is(studentMap));
    }
}
