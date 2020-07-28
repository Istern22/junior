package ru.job4j.solid.srp;

import java.util.function.Predicate;

public class ReportSalary implements Report {

    private Store store;

    public ReportSalary(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append((employee.getSalary() * 0.012)).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
