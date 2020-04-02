package ru.job4j.io;

import java.io.File;
import java.util.ArrayList;

public class ArgZip {
    private final String[] args;

    private ArrayList<String> errors = new ArrayList<String>();

    public ArgZip(String[] args) {
        this.args = args;
    }

    private void validation() {
        if (!args[0].equals("-d")) {
            errors.add("No direction key");
        }
        if (args[1] == null) {
            errors.add("No direction way");
        }
        if (!args[2].equals("-e")) {
            errors.add("No exclusion key");
        }
        if (args[3] == null) {
            errors.add("No exclusion");
        }
        if (!args[4].equals("-o")) {
            errors.add("Not output key");
        }
        if (args[5] == null) {
            errors.add("Not output name");
        }
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

    public String exclude() {
        return args[3].substring(2);
    }

    public String output() {
        return args[5];
    }
}
