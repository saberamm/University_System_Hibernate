package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
@Entity
public class Student extends User {
    @Column(name = "student_number")
    @Size(min = 5, max = 5, message = "student Number must have 5 digits")
    @NotNull(message = "student Number cannot be null")
    private String studentNumber;
    @ManyToMany(cascade = CascadeType.ALL)
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
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", birthDate=" + getBirthDate() +
                ", courses=" + courses +
                '}';
    }
}
