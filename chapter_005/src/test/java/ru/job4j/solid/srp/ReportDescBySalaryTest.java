package ru.job4j.solid.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportDescBySalaryTest {

    @Test
    public void whenGenerateDescending() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        store.add(new Employee("Petr", now.getTime(), now.getTime(), 100));
        store.add(new Employee("Ivan", now.getTime(), now.getTime(), 200));
        store.add(new Employee("Anna", now.getTime(), now.getTime(), 150));
        ReportDescBySalary report = new ReportDescBySalary(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append("Ivan;200.0;")
                .append(System.lineSeparator())
                .append("Anna;150.0;")
                .append(System.lineSeparator())
                .append("Petr;100.0;");
        assertThat(report.generate(em -> true), is(expect.toString()));
    }
}