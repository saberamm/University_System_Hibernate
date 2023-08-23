package ui;

import entity.Employee;
import entity.Student;
import entity.Teacher;
import entity.User;
import util.ApplicationContext;
import util.SecurityContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UserMenu {
    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        int choice;
        System.out.println("================");
        System.out.println("Options:");
        System.out.println("1. Signing section");
        System.out.println("0. exit");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        System.out.println();

        switch (choice) {
            case 1:
                userSigning();
            case 0:
                System.exit(0);
            default:
                System.out.println("*****Invalid choice. Please try again*****");
                run();
        }
    }

    public static void userSigning() {
        System.out.print("Enter username : ");
        String username = scanner.next();
        System.out.print("Enter password : ");
        String password = scanner.next();

        User user = ApplicationContext.getUserService().userAuthentication(username, password);
        if (user != null) {
            SecurityContext.id = user.getId();
            SecurityContext.username = user.getUsername();
            SecurityContext.firstname = user.getFirstName();
            SecurityContext.lastname = user.getLastName();
            if (user.getClass().getSimpleName().equals("Student")) {
                Student student = ApplicationContext.getStudentService().findById(user.getId());
                SecurityContext.studentNumber = student.getStudentNumber();
            }
            if (user.getClass().getSimpleName().equals("Teacher")) {
                Teacher teacher = ApplicationContext.getTeacherService().findById(user.getId());
                SecurityContext.teacherNumber = teacher.getTeacherNumber();
            }
            if (user.getClass().getSimpleName().equals("Employee")) {
                Employee employee = ApplicationContext.getEmployeeService().findById(user.getId());
                SecurityContext.employeeNumber = employee.getEmployeeNumber();
                EmployeeMenu.run();
            }
        } else {
            System.out.println("*****Username or password is wrong*****");
            UserMenu.userSigning();
        }


    }

    public static LocalDate dateFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy,M,d");
        LocalDate localDate = null;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter a date in the format (yyyy,M,d): ");
            String dateString = scanner.nextLine();

            try {
                localDate = LocalDate.parse(dateString, formatter);
                validInput = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use yyyy,M,d.");
            }
        }
        return localDate;
    }
}
