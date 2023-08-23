package ui;

import entity.Course;
import entity.Employee;
import entity.Student;
import entity.Teacher;
import entity.enumeration.Semester;
import jakarta.persistence.EntityNotFoundException;
import util.ApplicationContext;
import util.SecurityContext;
import validations.TypeValidator;

import static ui.UserMenu.scanner;

public class EmployeeMenu {
    public static void run() {
        int choice;
        System.out.println("================");
        System.out.println("Options:");
        System.out.println("1.  student section");
        System.out.println("2.  teacher section");
        System.out.println("3.  employee section");
        System.out.println("4.  course section");
        System.out.println("5.  payslip section");
        System.out.println("0. exit");
        System.out.print("Enter your choice: ");
        choice = TypeValidator.getIntInput();
        System.out.println();

        switch (choice) {
            case 1:
                studentEdit();
            case 2:
                teacherEdit();
            case 3:
                employeeEdit();
            case 4:
                courseEdit();
            case 5:
                paySlip();
            case 0:
                SecurityContext.clear();
                UserMenu.run();
            default:
                System.out.println("*****Invalid choice. Please try again*****");
                run();
        }
    }

    private static void courseEdit() {
        int choice;
        System.out.println("================");
        System.out.println("Options:");
        System.out.println("1.  save course");
        System.out.println("2.  delete course");
        System.out.println("3.  update course");
        System.out.println("0. back");
        System.out.print("Enter your choice: ");
        choice = TypeValidator.getIntInput();
        System.out.println();

        switch (choice) {
            case 1:
                saveCourse();
            case 2:
                deleteCourse();
            case 3:
                updateCourse();
            case 0:
                run();
            default:
                System.out.println("*****Invalid choice. Please try again*****");
                courseEdit();
        }
    }

    private static void updateCourse() {
        System.out.print("Enter course number :");
        Course course = ApplicationContext.getCourseService().findByCourseNumber(scanner.next());
        try {
            if (course != null) {
                System.out.print("Enter the course name :");
                course.setCourseName(scanner.next());
                System.out.print("Enter the course credit :");
                course.setCourseCredit(TypeValidator.getIntInput());
                System.out.print("Enter the course number :");
                course.setCourseNumber(scanner.next());
                System.out.print("Enter course semester :");
                course.setSemester(Semester.selectSemester());
                System.out.print("Enter a teacher number :");
                course.setTeacher(ApplicationContext.getTeacherService().findByTeacherNumber(scanner.next()));
                if (ApplicationContext.getCourseService().isValid(course)) {
                    ApplicationContext.getCourseService().update(course);
                    courseEdit();
                } else updateCourse();
            } else throw new EntityNotFoundException("student not found try again");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
            updateCourse();
        }
    }

    private static void deleteCourse() {
        System.out.print("Enter the course number :");
        ApplicationContext.getCourseService().deleteByCourseNumber(scanner.next());
        courseEdit();
    }

    private static void saveCourse() {
        Course course = new Course();
        System.out.print("Enter the course name :");
        course.setCourseName(scanner.next());
        System.out.print("Enter the course credit :");
        course.setCourseCredit(TypeValidator.getIntInput());
        System.out.print("Enter the course number :");
        course.setCourseNumber(scanner.next());
        System.out.print("Enter course semester :");
        course.setSemester(Semester.selectSemester());
        System.out.print("Enter a teacher number :");
        course.setTeacher(ApplicationContext.getTeacherService().findByTeacherNumber(scanner.next()));
        if (ApplicationContext.getCourseService().isValid(course)) {
            ApplicationContext.getCourseService().save(course);
            courseEdit();
        } else saveCourse();
    }

    private static void employeeEdit() {
        int choice;
        System.out.println("================");
        System.out.println("Options:");
        System.out.println("1.  signup employee");
        System.out.println("2.  delete employee");
        System.out.println("3.  update employee");
        System.out.println("0. back");
        System.out.print("Enter your choice: ");
        choice = TypeValidator.getIntInput();
        System.out.println();

        switch (choice) {
            case 1:
                signupEmployee();
            case 2:
                deleteEmployee();
            case 3:
                updateEmployee();
            case 0:
                run();
            default:
                System.out.println("*****Invalid choice. Please try again*****");
                employeeEdit();
        }
    }

    private static void updateEmployee() {
        System.out.println("Enter employee number :");
        Employee employee = ApplicationContext.getEmployeeService().findByEmployeeNumber(scanner.next());
        try {
            if (employee != null) {
                System.out.print("Enter the first name :");
                employee.setFirstName(scanner.next());
                System.out.print("Enter the last name :");
                employee.setLastName(scanner.next());
                System.out.print("Enter the user name :");
                employee.setUsername(scanner.next());
                System.out.print("Enter employee salary :");
                employee.setEmployeeSalary(TypeValidator.getLongInput());
                System.out.print("Enter the birth date :");
                employee.setBirthDate(TypeValidator.dateFormatter());
                System.out.print("Enter the employee number :");
                employee.setEmployeeNumber(scanner.next());
                System.out.println("Enter ");
                if (ApplicationContext.getEmployeeService().isValid(employee)) {
                    ApplicationContext.getEmployeeService().update(employee);
                    employeeEdit();
                } else updateEmployee();
            } else throw new EntityNotFoundException("student not found try again");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
            updateEmployee();
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter the employee number :");
        ApplicationContext.getEmployeeService().deleteByEmployeeNumber(scanner.next());
        employeeEdit();
    }

    private static void signupEmployee() {
        Employee employee = new Employee();
        System.out.print("Enter the first name :");
        employee.setFirstName(scanner.next());
        System.out.print("Enter the last name :");
        employee.setLastName(scanner.next());
        System.out.print("Enter the user name :");
        employee.setUsername(scanner.next());
        System.out.print("Enter employee salary :");
        employee.setEmployeeSalary(TypeValidator.getLongInput());
        System.out.print("Enter the password :");
        employee.setPassword(scanner.next());
        System.out.print("Enter the birth date :");
        employee.setBirthDate(TypeValidator.dateFormatter());
        System.out.print("Enter the employee number :");
        employee.setEmployeeNumber(scanner.next());
        if (ApplicationContext.getEmployeeService().isValid(employee)) {
            ApplicationContext.getEmployeeService().save(employee);
            employeeEdit();
        } else signupEmployee();
    }

    private static void teacherEdit() {
        int choice;
        System.out.println("================");
        System.out.println("Options:");
        System.out.println("1.  signup teacher");
        System.out.println("2.  delete teacher");
        System.out.println("3.  update teacher");
        System.out.println("0. back");
        System.out.print("Enter your choice: ");
        choice = TypeValidator.getIntInput();
        System.out.println();

        switch (choice) {
            case 1:
                signupTeacher();
            case 2:
                deleteTeacher();
            case 3:
                updateTeacher();
            case 0:
                run();
            default:
                System.out.println("*****Invalid choice. Please try again*****");
                teacherEdit();
        }
    }

    private static void updateTeacher() {
        System.out.println("Enter teacher number :");
        Teacher teacher = ApplicationContext.getTeacherService().findByTeacherNumber(scanner.next());
        try {
            if (teacher != null) {
                System.out.print("Enter the first name :");
                teacher.setFirstName(scanner.next());
                System.out.print("Enter the last name :");
                teacher.setLastName(scanner.next());
                System.out.print("Enter the user name :");
                teacher.setUsername(scanner.next());
                System.out.print("Enter teacher salary :");
                teacher.setTeacherSalary(TypeValidator.getLongInput());
                System.out.print("is teacher Academic staff?(True or False) :");
                teacher.setAcademicStaff(TypeValidator.getBooleanInput());
                System.out.print("Enter the birth date :");
                teacher.setBirthDate(TypeValidator.dateFormatter());
                System.out.print("Enter the teacher number :");
                teacher.setTeacherNumber(scanner.next());
                if (ApplicationContext.getTeacherService().isValid(teacher)) {
                    ApplicationContext.getTeacherService().update(teacher);
                    teacherEdit();
                } else updateTeacher();
            } else throw new EntityNotFoundException("teacher not found try again");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
            updateTeacher();
        }
    }

    private static void deleteTeacher() {
        System.out.print("Enter the teacher number :");
        ApplicationContext.getTeacherService().deleteByTeacherNumber(scanner.next());
        teacherEdit();
    }

    private static void signupTeacher() {
        Teacher teacher = new Teacher();
        System.out.print("Enter the first name :");
        teacher.setFirstName(scanner.next());
        System.out.print("Enter the last name :");
        teacher.setLastName(scanner.next());
        System.out.print("Enter the user name :");
        teacher.setUsername(scanner.next());
        System.out.print("Enter teacher salary :");
        teacher.setTeacherSalary(TypeValidator.getLongInput());
        System.out.print("is teacher Academic staff?(True or False) :");
        teacher.setAcademicStaff(TypeValidator.getBooleanInput());
        System.out.print("Enter the password :");
        teacher.setPassword(scanner.next());
        System.out.print("Enter the birth date :");
        teacher.setBirthDate(TypeValidator.dateFormatter());
        System.out.print("Enter the teacher number :");
        teacher.setTeacherNumber(scanner.next());
        if (ApplicationContext.getTeacherService().isValid(teacher)) {
            ApplicationContext.getTeacherService().save(teacher);
            teacherEdit();
        } else signupTeacher();
    }

    private static void studentEdit() {
        int choice;
        System.out.println("================");
        System.out.println("Options:");
        System.out.println("1.  signup student");
        System.out.println("2.  delete student");
        System.out.println("3.  update student");
        System.out.println("0. back");
        System.out.print("Enter your choice: ");
        choice = TypeValidator.getIntInput();
        System.out.println();

        switch (choice) {
            case 1:
                signupStudent();
            case 2:
                deleteStudent();
            case 3:
                updateStudent();
            case 0:
                run();
            default:
                System.out.println("*****Invalid choice. Please try again*****");
                studentEdit();
        }
    }

    private static void updateStudent() {
        System.out.println("Enter student number :");
        Student student = ApplicationContext.getStudentService().findByStudentNumber(scanner.next());
        try {
            if (student != null) {
                System.out.print("Enter the first name :");
                student.setFirstName(scanner.next());
                System.out.print("Enter the last name :");
                student.setLastName(scanner.next());
                System.out.print("Enter the user name :");
                student.setUsername(scanner.next());
                System.out.print("Enter the birth date :");
                student.setBirthDate(TypeValidator.dateFormatter());
                System.out.print("Enter the student number :");
                student.setStudentNumber(scanner.next());
                if (ApplicationContext.getStudentService().isValid(student)) {
                    ApplicationContext.getStudentService().update(student);
                    studentEdit();
                } else updateStudent();
            } else throw new EntityNotFoundException("student not found try again");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
            updateStudent();
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter the student number :");
        ApplicationContext.getStudentService().deleteByStudentNumber(scanner.next());
        studentEdit();
    }

    private static void signupStudent() {
        Student student = new Student();
        System.out.print("Enter the first name :");
        student.setFirstName(scanner.next());
        System.out.print("Enter the last name :");
        student.setLastName(scanner.next());
        System.out.print("Enter the user name :");
        student.setUsername(scanner.next());
        System.out.print("Enter the password :");
        student.setPassword(scanner.next());
        System.out.print("Enter the birth date :");
        student.setBirthDate(TypeValidator.dateFormatter());
        System.out.print("Enter the student number :");
        student.setStudentNumber(scanner.next());
        if (ApplicationContext.getStudentService().isValid(student)) {
            ApplicationContext.getStudentService().save(student);
            studentEdit();
        } else signupStudent();
    }

    private static void paySlip() {
        Employee employee = ApplicationContext.getEmployeeService().findByEmployeeNumber(SecurityContext.employeeNumber);
        System.out.println("Salary :" + employee.getEmployeeSalary());
        System.out.println("First name :" + employee.getFirstName());
        System.out.println("Last name :" + employee.getLastName());
        System.out.println("Employee number :" + employee.getEmployeeNumber());
        run();
    }
}
