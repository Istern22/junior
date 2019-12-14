package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted(new ScoreReverseComparator())
                .takeWhile(student -> student.getScore() > bound)
                .collect(Collectors.toList());
    }
}
