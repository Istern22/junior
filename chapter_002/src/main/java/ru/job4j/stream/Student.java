package ru.job4j.stream;

public class Student {

    private Integer score;

    private String surname;

    public Student(int score) {
        this.score = score;
    }

    public Student(String surname, int score) {
        this.surname = surname;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        return this.toString().equals(((Student) o).toString());
    }

    public int hashCode() {
        return this.score.hashCode();
    }

    @Override
    public String toString() {
        return "Address{"
                + "surname='" + surname + '\''
                + "score='" + score + '\''
                + '}';
    }
}
