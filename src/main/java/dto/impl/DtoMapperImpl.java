package dto.impl;

import dto.DtoMapper;
import entity.Student;
import entity.Teacher;
import entity.User;
import entity.dto.SimpleStudent;
import entity.dto.SimpleTeacher;
import entity.dto.SimpleUser;

public class DtoMapperImpl implements DtoMapper {
    @Override
    public SimpleUser userDtoMapper(User user) {
        if (user == null) {
            return null;
        }
        SimpleUser simpleUser = new SimpleUser();
        simpleUser.setFirstname(user.getFirstName());
        simpleUser.setLastname(user.getLastName());
        simpleUser.setUsername(user.getUsername());
        simpleUser.setBirthDate(user.getBirthDate());

        return simpleUser;
    }

    @Override
    public SimpleStudent studentDtoMapper(Student student) {
        if (student == null) {
            return null;
        }
        SimpleStudent Simplestudent = new SimpleStudent();
        Simplestudent.setFirstname(student.getFirstName());
        Simplestudent.setLastname(student.getLastName());
        Simplestudent.setUsername(student.getUsername());
        Simplestudent.setBirthDate(student.getBirthDate());
        Simplestudent.setStudentNumber(student.getStudentNumber());

        return Simplestudent;
    }

    @Override
    public SimpleTeacher teacherDtoMapper(Teacher teacher) {
        if (teacher == null) {
            return null;
        }
        SimpleTeacher Simpleteacher = new SimpleTeacher();
        Simpleteacher.setFirstname(teacher.getFirstName());
        Simpleteacher.setLastname(teacher.getLastName());
        Simpleteacher.setUsername(teacher.getUsername());
        Simpleteacher.setBirthDate(teacher.getBirthDate());
        Simpleteacher.setTeacherNumber(teacher.getTeacherNumber());

        return Simpleteacher;
    }
}
