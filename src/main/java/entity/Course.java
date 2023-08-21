package entity;

import base.entity.BaseEntity;
import entity.enumeration.Semester;
import jakarta.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
@Entity
public class Course extends BaseEntity<Long> {

    private String courseName;
    @Min(value = 1, message = "Course score must be at least 1")
    @Max(value = 20, message = "Course score must not exceed 20")
    private String courseScore;
    @Enumerated(EnumType.STRING)
    private Semester semester;
    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public Course(String courseName, String courseScore, Semester semester, Teacher teacher, List<Student> students) {
        this.courseName = courseName;
        this.courseScore = courseScore;
        this.semester = semester;
        this.teacher = teacher;
        this.students = students;
    }

    public Course(String courseName, Semester semester, Teacher teacher) {
        this.courseName = courseName;
        this.semester = semester;
        this.teacher = teacher;
    }

    public Course(String courseName, Semester semester) {
        this.courseName = courseName;
        this.semester = semester;
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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + getId() +
                ", courseName='" + courseName + '\'' +
                ", courseScore='" + courseScore + '\'' +
                ", semester=" + semester +
                ", teacher=" + teacher +
                '}';
    }
}
