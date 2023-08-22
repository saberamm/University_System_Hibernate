package util;


import dto.DtoMapper;
import dto.impl.DtoMapperImpl;
import jakarta.persistence.EntityManager;
import repository.*;
import repository.impl.*;
import service.*;
import service.impl.*;

public class ApplicationContext {
    static EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();

    //------------ user application context ------------------//

    private static final UserService userService;

    static {
        DtoMapper dtoMapper = new DtoMapperImpl();
        UserRepository userRepository = new UserRepositoryImpl(entityManager);
        userService = new UserServiceImpl(userRepository, dtoMapper);
    }

    public static UserService getUserService() {
        return userService;
    }

    //------------ Course application context ------------------//

    private static final CourseService courseService;

    static {
        CourseRepository courseRepository = new CourseRepositoryImpl(entityManager);
        courseService = new CourseServiceImpl(courseRepository);
    }

    public static CourseService getCourseService() {
        return courseService;
    }

    //------------ Student application context ------------------//

    private static final StudentService studentService;

    static {
        StudentRepository studentRepository = new StudentRepositoryImpl(entityManager);
        studentService = new StudentServiceImpl(studentRepository);
    }

    public static StudentService getStudentService() {
        return studentService;
    }

    //------------ Teacher application context ------------------//

    private static final TeacherService teacherService;

    static {
        TeacherRepository teacherRepository = new TeacherRepositoryImpl(entityManager);
        teacherService = new TeacherServiceImpl(teacherRepository);
    }

    public static TeacherService getTeacherService() {
        return teacherService;
    }

    //------------ Employee application context ------------------//

    private static final EmployeeService employeeService;

    static {
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(entityManager);
        employeeService = new EmployeeServiceImpl(employeeRepository);
    }

    public static EmployeeService getEmployeeService() {
        return employeeService;
    }

    //------------ Course Student application context ------------------//

    private static final CourseStudentService courseStudentService;

    static {
        CourseStudentRepository courseStudentRepository = new CourseStudentRepositoryImpl(entityManager);
        courseStudentService = new CourseStudentServiceImpl(courseStudentRepository);
    }

    public static CourseStudentService getCourseStudentService() {
        return courseStudentService;
    }

}
