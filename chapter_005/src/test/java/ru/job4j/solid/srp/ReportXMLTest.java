package ru.job4j.solid.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportXMLTest {
    @Test
    public void whenReportInXML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Petr", now.getTime(), now.getTime(), 100);
        store.add(worker);
        ReportXML report = new ReportXML(store);
        StringBuilder expect = new StringBuilder()
                .append("<report>").append(System.lineSeparator())
                .append("<employee>").append(System.lineSeparator())
                .append("<name>").append(worker.getName()).append("</name>").append(System.lineSeparator())
                .append("<hired>").append(worker.getHired()).append("</hired>").append(System.lineSeparator())
                .append("<fired>").append(worker.getFired()).append("</fired>").append(System.lineSeparator())
                .append("<salary>").append(worker.getSalary()).append("</salary>").append(System.lineSeparator())
                .append("</employee>").append(System.lineSeparator())
                .append("</report>");
        assertThat(report.generate(em -> true), is(expect.toString()));
    }

}