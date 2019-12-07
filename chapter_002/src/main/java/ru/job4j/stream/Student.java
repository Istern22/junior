package ru.job4j.stream;

public class Student {

    private Integer score;

    public Student(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        return this.score.equals(((Student) o).getScore());
    }

    public int hashCode() {
        return this.score.hashCode();
    }

}
