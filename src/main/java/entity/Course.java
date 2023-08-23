package entity;

import base.entity.BaseEntity;
import entity.enumeration.Semester;
import jakarta.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Course extends BaseEntity<Long> {
    @NotNull(message = "course Name cannot be null")
    private String courseName;
    @Column(name = "course_number")
    @Size(min = 5, max = 5, message = "course Number must have 5 digits")
    @NotNull(message = "course Number cannot be null")
    private String courseNumber;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "semester cannot be null")
    private Semester semester;
    @NotNull(message = "course Credit cannot be null")
    @Min(value = 1, message = "course Credit must be at least 1")
    @Max(value = 3, message = "course Credit must not exceed 3")
    private int courseCredit;
    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;
    @OneToMany(mappedBy = "course")
    private List<CourseStudent> courseStudents;

    public Course(String courseName, String courseNumber, Semester semester, int courseCredit, Teacher teacher, List<CourseStudent> courseStudents) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.semester = semester;
        this.courseCredit = courseCredit;
        this.teacher = teacher;
        this.courseStudents = courseStudents;
    }

    public Course(String courseName, String courseNumber, Semester semester, int courseCredit) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.semester = semester;
        this.courseCredit = courseCredit;
    }

    public Course(String courseName, Semester semester, int courseCredit) {
        this.courseName = courseName;
        this.semester = semester;
        this.courseCredit = courseCredit;
    }

    public Course(String courseName, String courseNumber, Semester semester, int courseCredit, Teacher teacher) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.semester = semester;
        this.courseCredit = courseCredit;
        this.teacher = teacher;
    }

    public Course() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<CourseStudent> getCourseStudents() {
        return courseStudents;
    }

    public void setCourseStudents(List<CourseStudent> courseStudents) {
        this.courseStudents = courseStudents;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + getId() +
                ", courseName='" + courseName + '\'' +
                ", courseNumber='" + courseNumber + '\'' +
                ", courseCredit='" + courseCredit + '\'' +
                ", semester=" + semester +
                ", teacher=" + teacher +
                '}';
    }
}
