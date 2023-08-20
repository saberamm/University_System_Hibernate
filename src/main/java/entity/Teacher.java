package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Teacher extends User {
    @Column(name = "teacher_number")
    private String teacherNumber;
    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;

    public Teacher(String teacherNumber, List<Course> courses) {
        this.teacherNumber = teacherNumber;
        this.courses = courses;
    }

    public Teacher(String firstName, String lastName, String username, String password, LocalDate birthDate, String teacherNumber, List<Course> courses) {
        super(firstName, lastName, username, password, birthDate);
        this.teacherNumber = teacherNumber;
        this.courses = courses;

    }public Teacher(String firstName, String lastName, String username, String password, LocalDate birthDate, String teacherNumber) {
        super(firstName, lastName, username, password, birthDate);
        this.teacherNumber = teacherNumber;
    }

    public Teacher() {
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + getId() +
                ",  teacherNumber='" + teacherNumber + '\'' +
                ", courses=" + courses +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", birthDate=" + getBirthDate() +
                '}';
    }
}
