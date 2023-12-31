package repository;

import base.repository.BaseRepository;
import entity.Student;

public interface StudentRepository extends BaseRepository<Student, Long> {
    void deleteByStudentNumber(String studentNumber);

    Student findByStudentNumber(String studentNumber);
}
