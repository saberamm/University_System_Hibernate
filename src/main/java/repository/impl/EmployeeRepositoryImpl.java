package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import repository.EmployeeRepository;

public class EmployeeRepositoryImpl extends BaseRepositoryImpl<Employee, Long> implements EmployeeRepository {
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }
    @Override
    public void deleteByEmployeeNumber(String employeeNumber) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Employee> deleteQuery = builder.createCriteriaDelete(Employee.class);
        Root<Employee> root = deleteQuery.from(Employee.class);

        deleteQuery.where(builder.equal(root.get("employeeNumber"), employeeNumber));

        entityManager.createQuery(deleteQuery).executeUpdate();
    }

    @Override
    @Transactional
    public Employee findByEmployeeNumber(String employeeNumber) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);

        criteriaQuery.select(root).where(builder.equal(root.get("employeeNumber"), employeeNumber));

        return entityManager.createQuery(criteriaQuery).getResultStream().findFirst().orElse(null);
    }
}
