package service;

import base.service.BaseService;
import entity.Course;
import entity.enumeration.Semester;

import java.util.List;

public interface CourseService extends BaseService<Course, Long> {
    void deleteByCourseNumber(String courseNumber);

    Course findByCourseNumber(String courseNumber);
    List<Course> getCoursesForStudentInTerm(String studentNumber, Semester semester);

    List<Course> findAllByIds(List<Long> courseIds);

    List<Course> getCoursesByTeacherNumberAndSemester(String teacherNumber, Semester semester);
}
