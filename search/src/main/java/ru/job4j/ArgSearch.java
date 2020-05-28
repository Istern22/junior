package ru.job4j;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.function.Predicate;

public class ArgSearch {
    private final String[] args;

    private ArrayList<String> errors = new ArrayList<>();

    private boolean getHelp;

    private boolean noArgs;

    public ArgSearch(String[] args) {
        this.args = args;
    }

    private void validation() {
        if (args.length == 0) {
            noArgs = true;
            return;
        }
        if (args[0].equals("-h")) {
            getHelp = true;
            return;
        }
        if (!args[0].equals("-d")) {
            errors.add("No direction key");
        }
        if (args[1] == null) {
            errors.add("No direction way");
        }
        if (!args[2].equals("-n")) {
            errors.add("No name key");
        }
        if (args[3] == null) {
            errors.add("No name");
        }
        if (!args[4].equals("-m") && !args[4].equals("-f")) {
            errors.add("No name option");
        }
        if (!args[5].equals("-o")) {
            errors.add("No output key");
        }
        if (args[6] == null) {
            errors.add("No output name");
        }
    }

    public boolean needHelp() {
        return getHelp;
    }

    public boolean needArgs() {
        return noArgs;
    }

    public boolean isValid() {
        validation();
        return errors.size() == 0;
    }

    public ArrayList<String> getErrors() {
        return errors;
    }

    public String directory() {
        return args[1];
    }

    public String name() {
        return args[3];
    }

    public String form() {
        return args[4];
    }

    public String output() {
        return args[6];
    }
}
