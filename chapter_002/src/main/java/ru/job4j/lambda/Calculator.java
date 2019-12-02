package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Calculator {

    public List<Double> range(int start, int end, Function<Double, Double> function) {
        List<Double> result = new ArrayList<>();
        for (int x = start; x != end; x++) {
            result.add(function.apply((double) x));
        }
        return result;
    }
}
