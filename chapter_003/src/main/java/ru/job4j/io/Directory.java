package ru.job4j.io;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

class Shell {

    private Stack<String> directory = new Stack<>();

    Shell cd(final String path) {
        getDirectory(path);
        return this;
    }

    private void getDirectory(String path) {
        if (path.startsWith("//")) {
            directory = new Stack<>();
        }
        if (directory.empty()) {
            directory.push("/");
        }
        var actions = Arrays.stream(path.split("/"))
                .filter(x -> !(x.equals(".") || x.equals("")))
                .collect(Collectors.toList());
        for (var act : actions) {
            if (act.equals("..")) {
                directory.pop();
            } else {
                if (!directory.peek().equals("/")) {
                    act = "/" + act;
                }
                directory.push(act);
            }
        }
    }

    public String path() {
        if (directory.empty()) {
            directory.push("/");
        }
        return directory.stream().collect(Collectors.joining());
    }
}

public class Directory {

    public static void main(String[] args) {

        final Shell shell = new Shell();
        assert shell.path().equals("/");

        shell.cd("/");
        assert shell.path().equals("/");

        shell.cd("usr").cd("local");
        shell.cd("../local").cd("./");
        assert shell.path().equals("/usr/local");

        shell.cd("..");
        assert shell.path().equals("/usr");

        shell.cd("//lib///");
        assert shell.path().equals("/lib");
    }
}
