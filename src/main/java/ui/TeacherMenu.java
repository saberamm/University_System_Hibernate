package ui;

import dto.DtoMapper;
import dto.impl.DtoMapperImpl;
import entity.Course;
import entity.CourseStudent;
import entity.Teacher;
import entity.dto.SimpleStudent;
import entity.dto.SimpleTeacher;
import entity.enumeration.Semester;
import util.ApplicationContext;
import util.SecurityContext;
import validations.TypeValidator;

import java.util.List;

import static ui.UserMenu.scanner;

public class TeacherMenu {
    private static void run() {
        int choice;
        System.out.println("================");
        System.out.println("Teacher Section:");
        System.out.println("1. View Profile");
        System.out.println("2. Grade Students");
        System.out.println("3. View Pay Slip");
        System.out.println("0. Back");
        System.out.print("Enter your choice: ");
        choice = TypeValidator.getIntInput();
        System.out.println();

        switch (choice) {
            case 1:
                viewProfile();
            case 2:
                gradeStudents();
            case 3:
                viewPaySlip();
            case 0:
                SecurityContext.clear();
                UserMenu.run();
            default:
                System.out.println("*****Invalid choice. Please try again*****");
                run();
        }
    }

    private static void viewProfile() {
        DtoMapper dtoMapper = new DtoMapperImpl();
        SimpleTeacher teacher = dtoMapper.teacherDtoMapper(ApplicationContext.getTeacherService().findByTeacherNumber(SecurityContext.teacherNumber));
        System.out.println("First name :" + teacher.getFirstname());
        System.out.println("Last name :" + teacher.getFirstname());
        System.out.println("Last name :" + teacher.getLastname());
        System.out.println("Birth date :" + teacher.getBirthDate());
        System.out.println("User name :" + teacher.getUsername());
        System.out.println("User name :" + teacher.getUsername());
        run();
    }

    private static void gradeStudents() {
        Teacher teacher = ApplicationContext.getTeacherService().findByTeacherNumber(SecurityContext.teacherNumber);
        System.out.print("Enter student number :");
        String studentNumber = scanner.next();
        System.out.print("Enter course number :");
        String courseNumber = scanner.next();
        CourseStudent courseStudent = ApplicationContext.getCourseStudentService().getCourseStudentByCourseTeacherStudentNumbers(courseNumber, teacher.getTeacherNumber(), studentNumber);
        System.out.println("Enter the score");
        courseStudent.setScore((double) TypeValidator.getIntInput());
        ApplicationContext.getCourseStudentService().update(courseStudent);
        run();
    }

    private static void viewPaySlip() {
        System.out.print("Enter semester :");
        Semester semester = Semester.selectSemester();
        double salary = calculateSalary(semester);
        System.out.println("Your salary for term " + semester + " is: " + salary);
        run();
    }

    private static double calculateSalary(Semester semester) {
        Teacher teacher = ApplicationContext.getTeacherService().findByTeacherNumber(SecurityContext.teacherNumber);
        double salary = 0;
        List<Course> courseList = ApplicationContext.getCourseService().getCoursesByTeacherNumberAndSemester(teacher.getTeacherNumber(), semester);

        int totalCredits = 0;
        for (Course course : courseList) {
            totalCredits += course.getCourseCredit();
        }
        if (teacher.isAcademicStaff()) {
            salary = teacher.getTeacherSalary() + (totalCredits * 1000000L);
        } else {

            salary = totalCredits * 1000000;
        }

        return salary;
    }

}
