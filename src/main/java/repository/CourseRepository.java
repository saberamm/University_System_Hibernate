package repository;

import base.repository.BaseRepository;
import entity.Course;
import entity.enumeration.Semester;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CourseRepository extends BaseRepository<Course, Long> {
    void deleteByCourseNumber(String courseNumber);

    @Transactional
    Course findByCourseNumber(String courseNumber);

    List<Course> getCoursesForStudentInTerm(String studentNumber, Semester semester);

    List<Course> findAllByIds(List<Long> courseIds);

    List<Course> getCoursesByTeacherNumberAndSemester(String teacherNumber, Semester semester);
}
