package repository;

import base.repository.BaseRepository;
import entity.Teacher;
import jakarta.transaction.Transactional;

public interface TeacherRepository extends BaseRepository<Teacher, Long> {
    void deleteByTeacherNumber(String teacherNumber);

    @Transactional
    Teacher findByTeacherNumber(String teacherNumber);
}
