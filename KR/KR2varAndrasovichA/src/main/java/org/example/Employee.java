package org.example;

import java.time.LocalDate;
import java.util.Date;

public class Employee {
    private String name;
    private double salary;
    private Date hireDay;
    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }
    public String getName() {
        return name;
    }
}
