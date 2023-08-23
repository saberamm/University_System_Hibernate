package ui;

import entity.Student;
import util.ApplicationContext;
import util.SecurityContext;

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
        choice = scanner.nextInt();
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
        choice = scanner.nextInt();
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
    }

    private static void deleteCourse() {
    }

    private static void saveCourse() {
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
        choice = scanner.nextInt();
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
    }

    private static void deleteEmployee() {
    }

    private static void signupEmployee() {
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
        choice = scanner.nextInt();
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
    }

    private static void deleteTeacher() {
    }

    private static void signupTeacher() {
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
        choice = scanner.nextInt();
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
    }

    private static void deleteStudent() {
        System.out.println("Enter the student number");
        ApplicationContext.getStudentService().deleteByStudentNumber(scanner.next());
    }

    private static void signupStudent() {
        Student student = new Student();
        System.out.println("Enter the first name");
        student.setFirstName(scanner.next());
        System.out.println("Enter the last name");
        student.setLastName(scanner.next());
        System.out.println("Enter the user name");
        student.setUsername(scanner.next());
        System.out.println("Enter the password");
        student.setPassword(scanner.next());
        System.out.println("Enter the birth date");
        student.setBirthDate(UserMenu.dateFormatter());
        System.out.println("Enter the student number");
        student.setStudentNumber(scanner.next());
        if (ApplicationContext.getStudentService().isValid(student)) {
            ApplicationContext.getStudentService().save(student);
        } else signupStudent();
    }

    private static void paySlip() {
    }
}
