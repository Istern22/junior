package ru.job4j.stream;

import java.util.Comparator;

public class ScoreReverseComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return -1 * Integer.compare(o1.getScore(), o2.getScore());
    }
}
