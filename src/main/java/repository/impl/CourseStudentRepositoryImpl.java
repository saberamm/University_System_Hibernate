package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.CourseStudent;
import jakarta.persistence.EntityManager;
import repository.CourseStudentRepository;

public class CourseStudentRepositoryImpl extends BaseRepositoryImpl<CourseStudent, Long> implements CourseStudentRepository {
    public CourseStudentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<CourseStudent> getEntityClass() {
        return CourseStudent.class;
    }
}
