package ru.job4j;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.function.Predicate;

public class FormsFactory {

    public static Predicate<Path> form(ArgSearch argSearch) {

        String form = argSearch.form();
        String name = argSearch.name();

        Predicate<Path> result = path -> true;

        if (form.equals("-f")) {
            result = path -> path.toFile().getName().equals(argSearch.name());
        }
        if (form.equals("-m")) {
            result = path -> FileSystems.getDefault().getPathMatcher("glob:" + name).matches(path.getFileName());
        }
        return result;
    }
}
