package ru.job4j.profession;

public class Programmer extends Engineer {
    private Code code;
    private String test;

    public Programmer(String name, String surname, String education, long birthday) {
        super(name, surname, education, birthday);
    }

    public Code writeTest(Code code, String test) {
        return code;
    }
}
