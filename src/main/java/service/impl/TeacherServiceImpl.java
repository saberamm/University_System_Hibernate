package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Teacher;
import repository.TeacherRepository;
import service.TeacherService;

public class TeacherServiceImpl extends BaseServiceImpl<Teacher, Long, TeacherRepository> implements TeacherService {
    public TeacherServiceImpl(TeacherRepository repository) {
        super(repository);
    }
}
