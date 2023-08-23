package repository;

import entity.CourseStudent;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface CourseStudentRepository {
    Class<CourseStudent> getEntityClass();

    CourseStudent save(CourseStudent courseStudent);

    List<CourseStudent> saveAll(List<CourseStudent> courseStudents);

    CourseStudent update(CourseStudent courseStudent);

    void delete(CourseStudent courseStudent);

    List<CourseStudent> findAll();

    CourseStudent getCourseStudentByCourseTeacherStudentNumbers(String courseNumber, String teacherNumber, String studentNumber);

    EntityManager getEntityManager();
}
