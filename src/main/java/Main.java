import entity.*;
import entity.enumeration.Semester;
import util.ApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User("sss", "sss", "sss",
                "sss", LocalDate.of(2010, 5, 5));
        ApplicationContext.getUserService().save(user);

        Employee employee = new Employee("sss", "sss", "sse",
                "sss", LocalDate.of(1999, 9, 9), "123");
        //ApplicationContext.getEmployeeService().save(employee);

        Teacher teacher = new Teacher("ww", "ww", "ww", "ww", LocalDate.of(2005, 7, 7), "123");
        //ApplicationContext.getTeacherService().save(teacher);

        Teacher teacher1 = ApplicationContext.getTeacherService().findById(52L);
        // Course course = new Course("math", Semester.term_1_1402, teacher1);
        // ApplicationContext.getCourseService().save(course);
       // Course course2 = ApplicationContext.getCourseService().findById(1L);
       // course2.setTeacher(teacher1);
        List<Course> courseList = new ArrayList<>();
       // courseList.add(course2);
        Student student = new Student("rr", "rr", "rr", "rr", LocalDate.of(2004, 4, 4), "345");
        student.setCourses(courseList);
        //ApplicationContext.getStudentService().save(student);
    }
}
