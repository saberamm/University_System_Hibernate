package ui;

import dto.DtoMapper;
import dto.impl.DtoMapperImpl;
import entity.Course;
import entity.CourseStudent;
import entity.Student;
import entity.dto.SimpleStudent;
import entity.enumeration.Semester;
import util.ApplicationContext;
import util.SecurityContext;
import validations.TypeValidator;

import java.util.ArrayList;
import java.util.List;

import static ui.UserMenu.scanner;

public class StudentMenu {
    public static void run() {
        int choice;
        System.out.println("================");
        System.out.println("Options:");
        System.out.println("1.  student info section");
        System.out.println("2.  course list section");
        System.out.println("3.  Select unit  section");
        System.out.println("4.  lessons caught section");
        System.out.println("0. exit");
        System.out.print("Enter your choice: ");
        choice = TypeValidator.getIntInput();
        System.out.println();

        switch (choice) {
            case 1:
                studentInfo();
            case 2:
                courseList();
            case 3:
                SelectUnit();
            case 4:
                lessonsCaught();
            case 0:
                SecurityContext.clear();
                UserMenu.run();
            default:
                System.out.println("*****Invalid choice. Please try again*****");
                run();
        }
    }

    private static void lessonsCaught() {
        Student student = ApplicationContext.getStudentService().findByStudentNumber(SecurityContext.studentNumber);
        List<CourseStudent> courseStudents = student.getCourseStudents();

        if (courseStudents.isEmpty()) {
            System.out.println("You haven't taken any courses yet.");
        } else {
            System.out.println("Taken courses with scores:");
            for (CourseStudent courseStudent : courseStudents) {
                Course course = courseStudent.getCourse();
                Double score = courseStudent.getScore();

                if (score != null) {
                    System.out.println("Course: " + course.getCourseName() + " | Score: " + score);
                } else {
                    System.out.println("Course: " + course.getCourseName() + " | Score: Not available");
                }
            }
        }
        run();
    }

    private static void SelectUnit() {
        Semester currentSemester = Semester.selectSemester();
        Semester previousSemester = Semester.getPreviousTerm(currentSemester);
        Student student = ApplicationContext.getStudentService().findByStudentNumber(SecurityContext.studentNumber);

        Double previousSemesterGPA = getPreviousSemesterGPA(student, previousSemester);

        List<Course> passedCourses = getPassedCourses(student);

        List<Course> selectedCourses = new ArrayList<>();

        while (true) {
            System.out.println("Enter course number (0 to finish):");
            String courseNumber = scanner.next();

            if (courseNumber.equals("0")) {
                break;
            }

            Course course = ApplicationContext.getCourseService().findByCourseNumber(courseNumber);

            if (course == null) {
                System.out.println("Course not found with the given course number.");
                continue;
            }

            if (passedCourses.contains(course)) {
                System.out.println("You have already passed this course.");
                continue;
            }

            if (selectedCourses.stream().anyMatch(selectedCourse ->
                    selectedCourse != null && selectedCourse.getSemester() == currentSemester && selectedCourse.isSimilarTo(course))) {
                System.out.println("You cannot select a similar course in the same semester.");
                continue;
            }

            selectedCourses.add(course);
        }

        int maxCreditLimit = (previousSemesterGPA > 18) ? 24 : 20;

        int totalCredits = selectedCourses.stream()
                .mapToInt(Course::getCourseCredit)
                .sum();

        if (totalCredits > maxCreditLimit) {
            System.out.println("Total credits exceed the allowed limit.");
        } else {
            List<CourseStudent> enrolledCourses = new ArrayList<>();
            for (Course course : selectedCourses) {
                CourseStudent courseStudent = new CourseStudent();
                courseStudent.setStudent(student);
                courseStudent.setCourse(course);
                enrolledCourses.add(courseStudent);
            }
            for (CourseStudent courseStudent : enrolledCourses) {
                ApplicationContext.getCourseStudentService().save(courseStudent);
            }
            System.out.println("Courses enrolled successfully.");
        }
        run();
    }
    private static Double getPreviousSemesterGPA(Student student, Semester previousSemester) {
        List<CourseStudent> courseStudentList = student.getCourseStudents();

        Double totalGradePoints = (double) 0;
        int totalCredits = 0;

        for (CourseStudent courseStudent : courseStudentList) {
            Course course = courseStudent.getCourse();
            if (course.getSemester() == previousSemester) {
                Double score = courseStudent.getScore();
                int credits = course.getCourseCredit();
                totalGradePoints += score * credits;
                totalCredits += credits;
            }
        }

        if (totalCredits > 0) {
            return totalGradePoints / totalCredits;
        } else {
            return 0.0;
        }
    }
    private static List<Course> getPassedCourses(Student student) {
        List<CourseStudent> courseStudentList = student.getCourseStudents();
        List<Course> passedCourses = new ArrayList<>();

        for (CourseStudent courseStudent : courseStudentList) {
            Double score = courseStudent.getScore();
            if (score != null && score >= 10) {
                passedCourses.add(courseStudent.getCourse());
            }
        }

        return passedCourses;
    }

    private static void courseList() {
        List<Course> courseList = ApplicationContext.getCourseService().findAll();
        for (Course course : courseList) {
            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("Course semester: " + course.getSemester());
            System.out.println("Course number: " + course.getCourseNumber());
            System.out.println("Course teacher name: " + course.getTeacher().getFirstName() + course.getTeacher().getLastName());
            System.out.println("Course teacher number: " + course.getTeacher().getTeacherNumber());
            System.out.println("=================");
        }
        run();
    }

    private static void studentInfo() {
        DtoMapper dtoMapper = new DtoMapperImpl();
        SimpleStudent student = dtoMapper.studentDtoMapper(ApplicationContext.getStudentService().findByStudentNumber(SecurityContext.studentNumber));
        System.out.println("First name :" + student.getFirstname());
        System.out.println("Last name :" + student.getFirstname());
        System.out.println("Last name :" + student.getLastname());
        System.out.println("Birth date :" + student.getBirthDate());
        System.out.println("User name :" + student.getUsername());
        run();
    }
}
