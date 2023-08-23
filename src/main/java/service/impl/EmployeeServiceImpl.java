package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Employee;
import repository.EmployeeRepository;
import service.EmployeeService;

import java.time.LocalDate;

public class EmployeeServiceImpl extends BaseServiceImpl<Employee, Long, EmployeeRepository> implements EmployeeService {


    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }

    @Override
    public Employee signUp(String firstName, String lastName, String username, String password, LocalDate birthDate, String employeeNumber, Long employeeSalary) {

        Employee employee = new Employee(firstName, lastName, username, password, birthDate, employeeNumber, employeeSalary);
        if (!isValid(employee))
            return null;
        repository.getEntityManager().getTransaction().begin();
        employee = repository.save(employee);
        repository.getEntityManager().getTransaction().commit();
        return employee;
    }
    @Override
    public void deleteByEmployeeNumber(String employeeNumber) {
        repository.getEntityManager().getTransaction().begin();
        repository.deleteByEmployeeNumber(employeeNumber);
        repository.getEntityManager().getTransaction().commit();
    }

    @Override
    public Employee findByEmployeeNumber(String employeeNumber) {
        return repository.findByEmployeeNumber(employeeNumber);
    }
}
