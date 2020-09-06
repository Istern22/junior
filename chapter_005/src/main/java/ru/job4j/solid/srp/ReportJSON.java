package ru.job4j.solid.srp;

import java.util.function.Predicate;

public class ReportJSON implements Report {

    private Store store;

    public ReportJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        for (Employee employee : store.findBy(filter)) {
            text.append("{").append(System.lineSeparator())
                    .append("\"name\":").append(employee.getName()).append(",").append(System.lineSeparator())
                    .append("\"hired\":").append(employee.getHired()).append(",").append(System.lineSeparator())
                    .append("\"fired\":").append(employee.getFired()).append(",").append(System.lineSeparator())
                    .append("\"salary\":").append(employee.getSalary()).append(",").append(System.lineSeparator())
                    .append("}");
        }
        return text.toString();
    }
}
