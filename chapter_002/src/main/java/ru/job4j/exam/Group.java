package ru.job4j.exam;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Group {

    public static Map<String, Set<String>> sections(List<Student> students) {

        /**students.stream().flatMap(
                holder -> new Holder(String key, String value)
        ).collect(
                Collectors.groupingBy(t -> t.key,
                        Collector.of(
                                HashSet::new,
                                (set, el) ->
                                        (left, right) -> {left.addAll(right); return left; }
                         )
                )
        );*/

        return null;
    }

    static class Holder {
        String key, value;

        Holder(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
