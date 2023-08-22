package entity;

import base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
public class CourseStudent{
    @Id
    @ManyToOne
    private Student student;
    @Id
    @ManyToOne
    private Course course;
    @Min(value = 1, message = "Course score must be at least 1")
    @Max(value = 20, message = "Course score must not exceed 20")
    private double score;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class CourseStudenttId implements Serializable {
        private Student student;
        private Course course;
    }

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
                ", student=" + student +
                ", course=" + course +
                ", score=" + score +
                '}';
    }
}
