package service;

import base.service.BaseService;
import entity.Employee;

import java.time.LocalDate;

public interface EmployeeService extends BaseService<Employee, Long> {
    public boolean isValid(Employee employee);

    public Employee signUp(String firstName, String lastName, String username, String password,
                           LocalDate birthDate, String employeeNumber, Long employeeSalary);
}
