package repository;

import entity.CourseStudent;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface CourseStudentRepository {
    Class<CourseStudent> getEntityClass();

    CourseStudent save(CourseStudent courseStudent);

    CourseStudent update(CourseStudent courseStudent);

    void delete(CourseStudent courseStudent);

    List<CourseStudent> findAll();

    EntityManager getEntityManager();
}
