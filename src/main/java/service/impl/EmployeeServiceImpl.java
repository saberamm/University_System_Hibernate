package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Employee;
import repository.EmployeeRepository;
import service.EmployeeService;
import validations.EntityValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.Set;

public class EmployeeServiceImpl extends BaseServiceImpl<Employee, Long, EmployeeRepository> implements EmployeeService {
    private final Validator Validator;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
        this.Validator = EntityValidator.validator;
    }

    public Employee signUp(String firstName, String lastName, String username, String password, LocalDate birthDate, String employeeNumber, Long employeeSalary) {
        Employee employee = new Employee(firstName, lastName, username, password, birthDate, employeeNumber
                , employeeSalary);
        if (!isValid(employee))
            return null;
        repository.getEntityManager().getTransaction().begin();
        employee = repository.save(employee);
        repository.getEntityManager().getTransaction().commit();
        return employee;
    }

    @Override
    public boolean isValid(Employee employee) {
        Set<ConstraintViolation<Employee>> violations = Validator.validate(employee);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Employee> p : violations)
                System.out.println(p.getMessage());
            return false;
        }
        return true;
    }
}
