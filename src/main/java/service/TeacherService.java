package service;

import base.service.BaseService;
import entity.Teacher;

import java.time.LocalDate;

public interface TeacherService extends BaseService<Teacher, Long> {
    Teacher signUp(String firstName, String lastName, String username, String password, LocalDate birthDate, String teacherNumber, boolean academicStaff);
}
