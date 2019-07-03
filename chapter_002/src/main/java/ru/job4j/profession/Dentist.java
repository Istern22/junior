package ru.job4j.profession;

public class Dentist extends Doctor {
    private Tooth tooth;
    private Operation operation;
    private int number;

    public Dentist(String name, String surname, String education, long birthday){
        super(name,surname, education,birthday);
    }

    public void treat(Diagnose diagnose, Patient patient, String specifics, Tooth tooth){
        super.treat(diagnose, patient, specifics);
        return;
    }

    public Operation delete(Tooth tooth, int number, Patient patient) {
        return operation;
    }
}
