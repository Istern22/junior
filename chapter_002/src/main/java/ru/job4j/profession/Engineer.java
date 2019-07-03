package ru.job4j.profession;

public class Engineer extends Profession {
    private Technology technology;
    private Code code;

    public Code build(Code code, Technology technology) {
        return code;
    }

}
