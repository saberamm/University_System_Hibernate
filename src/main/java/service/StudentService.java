package service;

import base.service.BaseService;
import entity.Student;

import java.time.LocalDate;

public interface StudentService extends BaseService<Student, Long> {
    Student signUp(String firstName, String lastName, String username, String password, LocalDate birthDate, String studentNumber);
    void deleteByStudentNumber(String studentNumber);

    Student findByStudentNumber(String studentNumber);
}
