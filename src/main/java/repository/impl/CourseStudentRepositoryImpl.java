package repository.impl;

import entity.CourseStudent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceException;
import repository.CourseStudentRepository;

import java.util.List;

public class CourseStudentRepositoryImpl implements CourseStudentRepository {
    protected final EntityManager entityManager;

    public CourseStudentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Class<CourseStudent> getEntityClass() {
        return CourseStudent.class;
    }

    @Override
    public CourseStudent save(CourseStudent courseStudent) {
        try {
            entityManager.persist(courseStudent);
            return courseStudent;
        } catch (PersistenceException ex) {
            throw new RuntimeException("Error while saving entity: " + ex.getMessage(), ex);
        }
    }

    @Override
    public CourseStudent update(CourseStudent courseStudent) {
        try {
            return entityManager.merge(courseStudent);
        } catch (PersistenceException ex) {
            throw new RuntimeException("Error while updating entity: " + ex.getMessage(), ex);
        }
    }

    @Override
    public void delete(CourseStudent courseStudent) {
        try {
            entityManager.remove(courseStudent);
        } catch (IllegalArgumentException ex) {
            throw new EntityNotFoundException("Entity not found");
        }
    }

    @Override
    public List<CourseStudent> findAll() {
        try {
            return entityManager.createQuery("from " + getEntityClass().getSimpleName(), getEntityClass()).getResultList();
        } catch (PersistenceException ex) {
            throw new RuntimeException("Error while fetching entities: " + ex.getMessage(), ex);
        }
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
