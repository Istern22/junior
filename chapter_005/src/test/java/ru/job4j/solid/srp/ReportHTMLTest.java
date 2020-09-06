package ru.job4j.solid.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportHTMLTest {
    @Test
    public void whenHTMLGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now.getTime(), now.getTime(), 100);
        store.add(worker);
        ReportHTML report = new ReportHTML(store);
        StringBuilder expect = new StringBuilder()
                .append("<body><p>")
                .append("Name; Hired; Fired; Salary;")
                .append("</p><p>")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append("</p></body>");
        assertThat(report.generate(em -> true), is(expect.toString()));
    }
}