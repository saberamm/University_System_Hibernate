package service;

import entity.CourseStudent;

import java.util.List;

public interface CourseStudentService {
    CourseStudent save(CourseStudent courseStudent);

    CourseStudent update(CourseStudent courseStudent);

    void delete(CourseStudent courseStudent);

    List<CourseStudent> findAll();

    boolean isValid(CourseStudent courseStudent);
    public List<CourseStudent> saveAll(List<CourseStudent> courseStudents);

    CourseStudent getCourseStudentByCourseTeacherStudentNumbers(String courseNumber, String teacherNumber, String studentNumber);
}
