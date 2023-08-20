package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.List;
@Entity
public class Student extends User {
    @Column(name = "student_number")
    private String studentNumber;
    @ManyToMany(mappedBy = "students")
    private List<Course> courses;

    public Student(String studentNumber, List<Course> courses) {
        this.studentNumber = studentNumber;
        this.courses = courses;
    }

    public Student(String firstName, String lastName, String username, String password, LocalDate birthDate, String studentNumber, List<Course> courses) {
        super(firstName, lastName, username, password, birthDate);
        this.studentNumber = studentNumber;
        this.courses = courses;

    } public Student(String firstName, String lastName, String username, String password, LocalDate birthDate, String studentNumber) {
        super(firstName, lastName, username, password, birthDate);
        this.studentNumber = studentNumber;
    }

    public Student() {
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", studentNumber='" + studentNumber + '\'' +
                ", courses=" + courses +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", birthDate=" + getBirthDate() +
                '}';
    }
}
