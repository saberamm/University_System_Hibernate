package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Teacher;
import repository.TeacherRepository;
import service.TeacherService;

import java.time.LocalDate;

public class TeacherServiceImpl extends BaseServiceImpl<Teacher, Long, TeacherRepository> implements TeacherService {
    public TeacherServiceImpl(TeacherRepository repository) {
        super(repository);
    }
    @Override
    public Teacher signUp(String firstName, String lastName, String username, String password, LocalDate birthDate, String teacherNumber,boolean academicStaff) {

        Teacher teacher = new Teacher(firstName, lastName, username, password, birthDate, teacherNumber,academicStaff);
        if (!isValid(teacher))
            return null;
        repository.getEntityManager().getTransaction().begin();
        teacher = repository.save(teacher);
        repository.getEntityManager().getTransaction().commit();
        return teacher;
    }
}
