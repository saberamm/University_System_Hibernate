package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Course;
import entity.enumeration.Semester;
import repository.CourseRepository;
import service.CourseService;

import java.util.List;

public class CourseServiceImpl extends BaseServiceImpl<Course, Long, CourseRepository> implements CourseService {
    public CourseServiceImpl(CourseRepository repository) {
        super(repository);
    }

    @Override
    public void deleteByCourseNumber(String courseNumber) {
        repository.getEntityManager().getTransaction().begin();
        repository.deleteByCourseNumber(courseNumber);
        repository.getEntityManager().getTransaction().commit();
    }

    @Override
    public Course findByCourseNumber(String courseNumber) {
        return repository.findByCourseNumber(courseNumber);
    }

    @Override
    public List<Course> getCoursesForStudentInTerm(String studentNumber, Semester semester) {
        return repository.getCoursesForStudentInTerm(studentNumber, semester);
    }
    @Override
    public List<Course> findAllByIds(List<Long> courseIds){
        return repository.findAllByIds(courseIds);
    }
    @Override
    public List<Course> getCoursesByTeacherNumberAndSemester(String teacherNumber, Semester semester){
        return repository.getCoursesByTeacherNumberAndSemester(teacherNumber,semester);
    }
}
