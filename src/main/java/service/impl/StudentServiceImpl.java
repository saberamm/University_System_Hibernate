package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Student;
import jakarta.transaction.Transactional;
import repository.StudentRepository;
import service.StudentService;

import java.time.LocalDate;

public class StudentServiceImpl extends BaseServiceImpl<Student, Long, StudentRepository> implements StudentService {
    public StudentServiceImpl(StudentRepository repository) {
        super(repository);
    }

    @Override
    public Student signUp(String firstName, String lastName, String username, String password, LocalDate birthDate, String studentNumber) {

        Student student = new Student(firstName, lastName, username, password, birthDate, studentNumber);
        if (!isValid(student))
            return null;
        repository.getEntityManager().getTransaction().begin();
        student = repository.save(student);
        repository.getEntityManager().getTransaction().commit();
        return student;
    }

    @Override
    public void deleteByStudentNumber(String studentNumber) {
        repository.getEntityManager().getTransaction().begin();
        repository.deleteByStudentNumber(studentNumber);
        repository.getEntityManager().getTransaction().commit();
    }

    @Override
    public Student findByStudentNumber(String studentNumber) {
        return repository.findByStudentNumber(studentNumber);
    }
}
