import org.example.Employee;

import java.time.*;
import java.util.Arrays;

public class EmployeeTest {

    public void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 2000 , 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 4000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 7000, 1990, 3, 15);
//поднять всем работникам зарплату на 5%
        for (Employee A : staff) {
            A.raiseSalary(5);
        }
        //вывести данные обо всех объектах типа Employee
        Arrays.stream(staff).map(A -> "name=" + A.getName() + ", salary=" + A.getSalary() + ", hireDay=" + A.getHireDay()).forEach(System.out::println);
    }

    class Employee {
        private String name;
        private double salary;
        private LocalDate hireDay;

        public Employee(String n, double s, int year, int month, int day) {
            name = n;
            salary = s;
            hireDay = LocalDate.of(year, month, day);
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public LocalDate getHireDay() {
            return hireDay;
        }

        public void raiseSalary(double byPercent) {
            double raise = salary * byPercent / 100;
            salary += raise;
        }
    }
}

