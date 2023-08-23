package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Teacher extends User {
    @Column(name = "teacher_number")
    @Size(min = 5, max = 5, message = "teacher Number must have 5 digits")
    @NotNull(message = "teacher Number cannot be null")
    private String teacherNumber;
    @NotNull(message = "teacher salary cannot be null")
    private Long teacherSalary;
    @NotNull(message = "academic Staff cannot be null")
    private boolean academicStaff;
    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;

    public Teacher(String teacherNumber, boolean academicStaff) {
        this.teacherNumber = teacherNumber;
        this.academicStaff = academicStaff;
    }


    public Teacher(String firstName, String lastName, String username, String password, LocalDate birthDate, String teacherNumber, boolean academicStaff) {
        super(firstName, lastName, username, password, birthDate);
        this.teacherNumber = teacherNumber;
        this.academicStaff = academicStaff;
    }

    public Teacher(String teacherNumber, boolean academicStaff, List<Course> courses) {
        this.teacherNumber = teacherNumber;
        this.academicStaff = academicStaff;
        this.courses = courses;
    }

    public Teacher(String teacherNumber, Long teacherSalary, boolean academicStaff, List<Course> courses) {
        this.teacherNumber = teacherNumber;
        this.teacherSalary = teacherSalary;
        this.academicStaff = academicStaff;
        this.courses = courses;
    }


    public Teacher(String firstName, String lastName, String username, String password, LocalDate birthDate, String teacherNumber, Long teacherSalary, boolean academicStaff, List<Course> courses) {
        super(firstName, lastName, username, password, birthDate);
        this.teacherNumber = teacherNumber;
        this.teacherSalary = teacherSalary;
        this.academicStaff = academicStaff;
        this.courses = courses;
    }

    public Teacher(String firstName, String lastName, String username, String password, LocalDate birthDate, String teacherNumber, boolean academicStaff, List<Course> courses) {
        super(firstName, lastName, username, password, birthDate);
        this.teacherNumber = teacherNumber;
        this.academicStaff = academicStaff;
        this.courses = courses;
    }

    public Teacher() {
    }

    public Long getTeacherSalary() {
        return teacherSalary;
    }

    public void setTeacherSalary(Long teacherSalary) {
        this.teacherSalary = teacherSalary;
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

    public boolean isAcademicStaff() {
        return academicStaff;
    }

    public void setAcademicStaff(boolean academicStaff) {
        this.academicStaff = academicStaff;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + getId() +
                ", teacherNumber='" + teacherNumber + '\'' +
                ", teacherSalary='" + teacherSalary + '\'' +
                ", academicStaff=" + academicStaff +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", birthDate=" + getBirthDate() +
                '}';
    }
}
