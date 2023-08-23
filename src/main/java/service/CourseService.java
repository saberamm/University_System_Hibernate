package service;

import base.service.BaseService;
import entity.Course;

public interface CourseService extends BaseService<Course, Long> {
    void deleteByCourseNumber(String courseNumber);

    Course findByCourseNumber(String courseNumber);
}
