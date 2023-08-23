package entity;

import base.entity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class CourseStudent{
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;
    @Min(value = 1, message = "Course score must be at least 1")
    @Max(value = 20, message = "Course score must not exceed 20")
    private Double score;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class CourseStudenttId implements Serializable {
        private Student student;
        private Course course;
    }

    public CourseStudent(Student student, Course course, Double score) {
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseStudent that = (CourseStudent) o;
        return Objects.equals(student, that.student) && Objects.equals(course, that.course) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, course, score);
    }
}
