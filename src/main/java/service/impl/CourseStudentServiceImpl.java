package service.impl;

import entity.CourseStudent;
import repository.CourseStudentRepository;
import service.CourseStudentService;
import validations.EntityValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

public class CourseStudentServiceImpl implements CourseStudentService {
    protected final CourseStudentRepository repository;
    protected final Validator validator = EntityValidator.validator;

    public CourseStudentServiceImpl(CourseStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public CourseStudent save(CourseStudent courseStudent) {
        if (!isValid(courseStudent))
            return null;
        repository.getEntityManager().getTransaction().begin();
        try {
            repository.save(courseStudent);
            repository.getEntityManager().getTransaction().commit();
        } catch (Exception ex) {
            if (repository.getEntityManager().getTransaction().isActive()) {
                repository.getEntityManager().getTransaction().rollback();
            }
            throw new RuntimeException("Error while saving entity: " + ex.getMessage(), ex);
        }
        return courseStudent;
    }

    @Override
    public CourseStudent update(CourseStudent courseStudent) {
        if (!isValid(courseStudent))
            return null;
        repository.getEntityManager().getTransaction().begin();
        try {
            repository.update(courseStudent);
            repository.getEntityManager().getTransaction().commit();
        } catch (Exception ex) {
            if (repository.getEntityManager().getTransaction().isActive()) {
                repository.getEntityManager().getTransaction().rollback();
            }
            throw new RuntimeException("Error while updating entity: " + ex.getMessage(), ex);
        }
        return courseStudent;
    }

    @Override
    public void delete(CourseStudent courseStudent) {
        try {
            repository.getEntityManager().getTransaction().begin();
            repository.delete(courseStudent);
            repository.getEntityManager().getTransaction().commit();
        } catch (Exception ex) {
            if (repository.getEntityManager().getTransaction().isActive()) {
                repository.getEntityManager().getTransaction().rollback();
            }
            throw new RuntimeException("Error while deleting entity: " + ex.getMessage(), ex);
        }
    }

    @Override
    public List<CourseStudent> findAll() {
        try {
            return repository.findAll();
        } catch (Exception ex) {
            throw new RuntimeException("Error while fetching entities: " + ex.getMessage(), ex);
        }
    }

    @Override
    public boolean isValid(CourseStudent courseStudent) {
        Set<ConstraintViolation<CourseStudent>> violations = validator.validate(courseStudent);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<CourseStudent> p : violations)
                System.out.println(p.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<CourseStudent> saveAll(List<CourseStudent> courseStudents) {
        return repository.saveAll(courseStudents);
    }
    @Override
    public CourseStudent getCourseStudentByCourseTeacherStudentNumbers(String courseNumber, String teacherNumber, String studentNumber){
        return repository.getCourseStudentByCourseTeacherStudentNumbers(courseNumber, teacherNumber, studentNumber);
    }
}
