package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Course;
import repository.CourseRepository;
import service.CourseService;

public class CourseServiceImpl extends BaseServiceImpl<Course, Long, CourseRepository> implements CourseService {
    public CourseServiceImpl(CourseRepository repository) {
        super(repository);
    }
}
