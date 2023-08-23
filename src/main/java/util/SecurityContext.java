package util;

import java.time.LocalDate;

public class SecurityContext {
    public static Long id;
    public static String firstname;
    public static String lastname;
    public static String username;
    public static String employeeNumber;
    public static String studentNumber;
    public static String teacherNumber;

    public static void clear() {
        id = null;
        firstname = null;
        lastname = null;
        username = null;
        employeeNumber = null;
        studentNumber = null;
        teacherNumber = null;
    }
}
