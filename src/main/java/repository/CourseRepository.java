package repository;

import base.repository.BaseRepository;
import entity.Course;
import jakarta.transaction.Transactional;

public interface CourseRepository extends BaseRepository<Course, Long> {
    void deleteByCourseNumber(String courseNumber);

    @Transactional
    Course findByCourseNumber(String courseNumber);
}
