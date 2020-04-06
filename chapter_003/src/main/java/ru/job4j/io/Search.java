package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Search {
    public static void main(String[] args) throws IOException {
        var start = Paths.get("E:\\книги");
        var result = search(start, "txt");
        for (var item : result) {
            System.out.println(item);
        }
    }

    public static List<String> search(Path root, String ext) throws IOException {
        var filter = new FilterFiles(ext);
        Files.walkFileTree(root, filter);
        return filter.getFiles();
    }
}
