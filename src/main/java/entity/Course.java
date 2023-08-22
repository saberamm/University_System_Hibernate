package entity;

import base.entity.BaseEntity;
import entity.enumeration.Semester;
import jakarta.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Course extends BaseEntity<Long> {
    @NotNull(message = "course Name cannot be null")
    private String courseName;
    @Min(value = 1, message = "Course score must be at least 1")
    @Max(value = 20, message = "Course score must not exceed 20")
    private String courseScore;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "semester cannot be null")
    private Semester semester;
    @NotNull(message = "course Credit cannot be null")
    @Min(value = 1, message = "course Credit must be at least 1")
    @Max(value = 3, message = "course Credit must not exceed 3")
    private int courseCredit;
    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public Course(String courseName, String courseScore, Semester semester, int courseCredit, Teacher teacher, List<Student> students) {
        this.courseName = courseName;
        this.courseScore = courseScore;
        this.semester = semester;
        this.courseCredit = courseCredit;
        this.teacher = teacher;
        this.students = students;
    }

    public Course(String courseName, String courseScore, Semester semester, int courseCredit) {
        this.courseName = courseName;
        this.courseScore = courseScore;
        this.semester = semester;
        this.courseCredit = courseCredit;
    }

    public Course(String courseName, Semester semester, int courseCredit) {
        this.courseName = courseName;
        this.semester = semester;
        this.courseCredit = courseCredit;
    }

    public Course(String courseName, Semester semester, int courseCredit, Teacher teacher) {
        this.courseName = courseName;
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

    public String getCourseScore() {
        return courseScore;
    }

    public void setCourseScore(String courseScore) {
        this.courseScore = courseScore;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + getId() +
                ", courseName='" + courseName + '\'' +
                ", courseCredit='" + courseCredit + '\'' +
                ", courseScore='" + courseScore + '\'' +
                ", semester=" + semester +
                ", teacher=" + teacher +
                '}';
    }
}
