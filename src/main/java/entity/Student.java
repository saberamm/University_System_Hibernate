package entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Student extends User {
    @Column(name = "student_number")
    @Size(min = 5, max = 5, message = "student Number must have 5 digits")
    @NotNull(message = "student Number cannot be null")
    private String studentNumber;
    @OneToMany(mappedBy = "student")
    private List<CourseStudent> courseStudents;

    public Student(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Student(String firstName, String lastName, String username, String password, LocalDate birthDate, String studentNumber) {
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

    public List<CourseStudent> getCourseStudents() {
        return courseStudents;
    }

    public void setCourseStudents(List<CourseStudent> courseStudents) {
        this.courseStudents = courseStudents;
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentNumber, student.studentNumber) && Objects.equals(courseStudents, student.courseStudents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNumber, courseStudents);
    }
}
