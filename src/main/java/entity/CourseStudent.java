package entity;

import base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class CourseStudent extends BaseEntity<Long> {
    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;
    @Min(value = 1, message = "Course score must be at least 1")
    @Max(value = 20, message = "Course score must not exceed 20")
    private double score;

    public CourseStudent(Student student, Course course, double score) {
        this.student = student;
        this.course = course;
        this.score = score;
    }

    public CourseStudent(double score) {
        this.score = score;
    }

    public CourseStudent() {

    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "CourseStudent{" +
                "id=" + getId() +
                ", student=" + student +
                ", course=" + course +
                ", score=" + score +
                '}';
    }
}
