package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(
                student -> predict.test(student)
        ).collect(Collectors.toList());
    }

    Map<String, Student> convert(List<Student> students) {
        return students.stream().distinct().collect(
                Collectors.toMap(
                        student -> student.getSurname(),
                        student -> student
                )
        );
    }
}
