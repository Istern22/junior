package ru.job4j.profession;

public class Doctor extends Profession {
    private int experience;
    private Diagnose diagnose;
    private Patient patient;
    private String specifics;

    public Doctor(String name, String surname, String education, long birthday) {
        super(name, surname, education, birthday);
    }

    public void treat(Diagnose diagnose, Patient patient, String specifics) {
        return;
    }

    public Diagnose heal(Patient patient) {
        return diagnose;
    }

    public Patient operate(Organ organ) {
        return patient;
    }

}