package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Employee;
import repository.EmployeeRepository;
import service.EmployeeService;

public class EmployeeServiceImpl extends BaseServiceImpl<Employee, Long, EmployeeRepository> implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }
}
