package repository.impl;

import entity.Course;
import entity.CourseStudent;
import entity.Student;
import entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.*;
import repository.CourseStudentRepository;

import java.util.ArrayList;
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
    public List<CourseStudent> saveAll(List<CourseStudent> courseStudents) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            List<CourseStudent> savedCourseStudents = new ArrayList<>();
            for (CourseStudent courseStudent : courseStudents) {
                entityManager.persist(courseStudent);
                savedCourseStudents.add(courseStudent);
            }

            transaction.commit();
            return savedCourseStudents;
        } catch (PersistenceException ex) {
            throw new RuntimeException("Error while updating entities: " + ex.getMessage(), ex);
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
    public CourseStudent getCourseStudentByCourseTeacherStudentNumbers(String courseNumber, String teacherNumber, String studentNumber) {
        EntityManager entityManager = getEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CourseStudent> criteriaQuery = criteriaBuilder.createQuery(CourseStudent.class);
        Root<CourseStudent> courseStudentRoot = criteriaQuery.from(CourseStudent.class);

        Join<CourseStudent, Course> courseJoin = courseStudentRoot.join("course");
        Join<Course, Teacher> teacherJoin = courseJoin.join("teacher");
        Join<CourseStudent, Student> studentJoin = courseStudentRoot.join("student");

        Predicate courseNumberPredicate = criteriaBuilder.equal(courseJoin.get("courseNumber"), courseNumber);
        Predicate teacherNumberPredicate = criteriaBuilder.equal(teacherJoin.get("teacherNumber"), teacherNumber);
        Predicate studentNumberPredicate = criteriaBuilder.equal(studentJoin.get("studentNumber"), studentNumber);

        Predicate finalPredicate = criteriaBuilder.and(courseNumberPredicate, teacherNumberPredicate, studentNumberPredicate);

        criteriaQuery.where(finalPredicate);

        CourseStudent courseStudent = entityManager.createQuery(criteriaQuery).getSingleResult();

        entityManager.close();

        return courseStudent;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
