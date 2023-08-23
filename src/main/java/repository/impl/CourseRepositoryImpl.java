package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import repository.CourseRepository;

public class CourseRepositoryImpl extends BaseRepositoryImpl<Course, Long> implements CourseRepository {

    public CourseRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Course> getEntityClass() {
        return Course.class;
    }
    @Override
    public void deleteByCourseNumber(String courseNumber) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Course> deleteQuery = builder.createCriteriaDelete(Course.class);
        Root<Course> root = deleteQuery.from(Course.class);

        deleteQuery.where(builder.equal(root.get("courseNumber"), courseNumber));

        entityManager.createQuery(deleteQuery).executeUpdate();
    }

    @Override
    @Transactional
    public Course findByCourseNumber(String courseNumber) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = builder.createQuery(Course.class);
        Root<Course> root = criteriaQuery.from(Course.class);

        criteriaQuery.select(root).where(builder.equal(root.get("courseNumber"), courseNumber));

        return entityManager.createQuery(criteriaQuery).getResultStream().findFirst().orElse(null);
    }
}
