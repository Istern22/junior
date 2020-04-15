package ru.job4j;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {

    public List<String> getFiles(String directory, String name, Predicate<Path> form) throws IOException {
        var filter = new FilterSearch(form);
        Files.walkFileTree(Paths.get(directory), filter);
        return filter.getFiles();
    }

    public void write(List<String> list, String output) {
        try (var out = new PrintWriter(new FileOutputStream(output))) {
            for (var item : list) {
                out.write(item);
                out.write(System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        var argsInput = new ArgSearch(args);
        if (argsInput.needArgs()) {
            System.out.println("No args!");
        }
        if (!argsInput.isValid()) {
            for (var error : argsInput.getErrors()) {
                System.out.println(error);
            }
            return;
        }
        if (argsInput.needHelp()) {
            System.out.println("-d - директория, в которой осуществляется поиск.\n"
                    + "-n - имя файл, маска, либо регулярное выражение.\n"
                    + "-m - искать по маске, либо -f - искать по имени, -r искать по регулярному выражению.\n"
                    + "-o - результат записать в указанный файл."
            );
        } else {
            Predicate<Path> condition = FormsFactory.form(argsInput);
            var search = new Search();
            var list = search.getFiles(argsInput.directory(), argsInput.name(), condition);
            search.write(list, argsInput.output());
        }
    }
}
