package ru.job4j.exam;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Group {

    public static Map<String, Set<String>> sections(List<Student> students)  {
        return students.stream()
                .flatMap(student -> student.getUnits().stream().map(unit -> new Holder(unit, student.getName())))
                .collect(Collectors.groupingBy(
                        holder -> holder.getKey(),
                        Collector.of(
                                () -> new HashSet<>(),
                                (set, holder) -> set.add(holder.getValue()),
                                (set1, set2) -> {
                                    set1.addAll(set2);
                                    return set1;
                                }
                        )));
    }

    static class Holder {
        private String key, value;

        Holder(String key, String value) {
            this.key = key;
            this.value = value;
        }
        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return key + " " + value;
        }
    }
}
