package dto;

import entity.Student;
import entity.Teacher;
import entity.User;
import entity.dto.SimpleStudent;
import entity.dto.SimpleTeacher;
import entity.dto.SimpleUser;

public interface DtoMapper {
    SimpleUser userDtoMapper(User user);
    SimpleStudent studentDtoMapper(Student student);
    SimpleTeacher teacherDtoMapper(Teacher teacher);
}
