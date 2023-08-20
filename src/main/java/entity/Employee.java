package entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;
@Entity
public class Employee extends User {
    @Column(name = "employee_number")
    private String employeeNumber;

    public Employee(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Employee(String firstName, String lastName, String username, String password, LocalDate birthDate, String employeeNumber) {
        super(firstName, lastName, username, password, birthDate);
        this.employeeNumber = employeeNumber;
    }

    public Employee() {
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
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", birthDate=" + getBirthDate() +
                '}';
    }
}
