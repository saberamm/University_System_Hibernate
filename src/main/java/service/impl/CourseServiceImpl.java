package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Course;
import repository.CourseRepository;
import service.CourseService;

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
}
