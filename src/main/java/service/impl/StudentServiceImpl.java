package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Student;
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
}
