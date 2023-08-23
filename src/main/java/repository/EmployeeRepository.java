package repository;

import base.repository.BaseRepository;
import entity.Employee;
import jakarta.transaction.Transactional;

public interface EmployeeRepository extends BaseRepository<Employee, Long> {
    void deleteByEmployeeNumber(String employeeNumber);

    @Transactional
    Employee findByEmployeeNumber(String employeeNumber);
}
