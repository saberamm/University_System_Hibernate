package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.CourseStudent;
import repository.CourseStudentRepository;
import service.CourseStudentService;

public class CourseStudentServiceImpl extends BaseServiceImpl<CourseStudent, Long, CourseStudentRepository> implements CourseStudentService {
    public CourseStudentServiceImpl(CourseStudentRepository repository) {
        super(repository);
    }
}
