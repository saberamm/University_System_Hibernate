package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Employee;
import jakarta.persistence.EntityManager;
import repository.EmployeeRepository;

public class EmployeeRepositoryImpl extends BaseRepositoryImpl<Employee, Long> implements EmployeeRepository {
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }
}
