package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import repository.TeacherRepository;

public class TeacherRepositoryImpl extends BaseRepositoryImpl<Teacher, Long> implements TeacherRepository {
    public TeacherRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Teacher> getEntityClass() {
        return Teacher.class;
    }
    @Override
    public void deleteByTeacherNumber(String teacherNumber) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Teacher> deleteQuery = builder.createCriteriaDelete(Teacher.class);
        Root<Teacher> root = deleteQuery.from(Teacher.class);

        deleteQuery.where(builder.equal(root.get("teacherNumber"), teacherNumber));

        entityManager.createQuery(deleteQuery).executeUpdate();
    }

    @Override
    @Transactional
    public Teacher findByTeacherNumber(String teacherNumber) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Teacher> criteriaQuery = builder.createQuery(Teacher.class);
        Root<Teacher> root = criteriaQuery.from(Teacher.class);

        criteriaQuery.select(root).where(builder.equal(root.get("teacherNumber"), teacherNumber));

        return entityManager.createQuery(criteriaQuery).getResultStream().findFirst().orElse(null);
    }
}
