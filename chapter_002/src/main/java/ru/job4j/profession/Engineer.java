package ru.job4j.profession;

public class Engineer extends Profession {
    private Technology technology;
    private Code code;

    public Engineer(String name, String surname, String education, long birthday) {
        super(name, surname, education, birthday);
    }

    public Code build(Code code, Technology technology) {
        return code;
    }

}
