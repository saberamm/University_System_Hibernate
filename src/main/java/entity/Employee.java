package entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Employee extends User {
    @Column(name = "employee_number")
    @Size(min = 5, max = 5, message = "employee Number must have 5 digits")
    @NotNull(message = "employee Number cannot be null")
    private String employeeNumber;
    @NotNull(message = "employee salary cannot be null")
    private Long employeeSalary;

    public Employee(String employeeNumber, Long employeeSalary) {
        this.employeeNumber = employeeNumber;
        this.employeeSalary = employeeSalary;
    }

    public Employee(String firstName, String lastName, String username, String password, LocalDate birthDate, String employeeNumber, Long employeeSalary) {
        super(firstName, lastName, username, password, birthDate);
        this.employeeNumber = employeeNumber;
        this.employeeSalary = employeeSalary;
    }

    public Employee() {
    }

    public Long getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Long employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", employeeSalary='" + employeeSalary + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", birthDate=" + getBirthDate() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeNumber, employee.employeeNumber) && Objects.equals(employeeSalary, employee.employeeSalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber, employeeSalary);
    }
}
