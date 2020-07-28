package ru.job4j.solid.srp;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportDescBySalary implements Report {

    private Store store;

    public ReportDescBySalary(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        List<Employee> employees = store.findBy(filter);
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o2.getSalary(), o1.getSalary());
            }
        });
        for (Employee employee : employees) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append((employee.getSalary())).append(";");
        }
        return text.toString();
    }
}
