package ru.job4j.solid.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportJSONTest {

    @Test
    public void whenReportInJSON() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Petr", now.getTime(), now.getTime(), 100);
        store.add(worker);
        ReportJSON report = new ReportJSON(store);
        StringBuilder expect = new StringBuilder();
        expect.append("{").append(System.lineSeparator())
                .append("\"name\":").append(worker.getName()).append(",").append(System.lineSeparator())
                .append("\"hired\":").append(worker.getHired()).append(",").append(System.lineSeparator())
                .append("\"fired\":").append(worker.getFired()).append(",").append(System.lineSeparator())
                .append("\"salary\":").append(worker.getSalary()).append(",").append(System.lineSeparator())
                .append("}");
        assertThat(report.generate(em -> true), is(expect.toString()));
    }
}