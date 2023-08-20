package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Course;
import jakarta.persistence.EntityManager;
import repository.CourseRepository;

public class CourseRepositoryImpl extends BaseRepositoryImpl<Course, Long> implements CourseRepository {

    public CourseRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Course> getEntityClass() {
        return Course.class;
    }
}
