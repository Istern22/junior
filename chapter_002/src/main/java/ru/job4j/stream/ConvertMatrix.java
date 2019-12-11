package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertMatrix {
    List<Integer> convertMatrix(List<List<Integer>> matrix) {
        return matrix.stream().flatMap(List::stream).collect(Collectors.toList());
    }
}
