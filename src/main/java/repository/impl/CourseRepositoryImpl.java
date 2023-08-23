package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Course;
import entity.CourseStudent;
import entity.Student;
import entity.Teacher;
import entity.enumeration.Semester;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import repository.CourseRepository;

import java.util.List;

public class CourseRepositoryImpl extends BaseRepositoryImpl<Course, Long> implements CourseRepository {

    public CourseRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Course> getEntityClass() {
        return Course.class;
    }
    @Override
    public void deleteByCourseNumber(String courseNumber) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Course> deleteQuery = builder.createCriteriaDelete(Course.class);
        Root<Course> root = deleteQuery.from(Course.class);

        deleteQuery.where(builder.equal(root.get("courseNumber"), courseNumber));

        entityManager.createQuery(deleteQuery).executeUpdate();
    }

    @Override
    @Transactional
    public Course findByCourseNumber(String courseNumber) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = builder.createQuery(Course.class);
        Root<Course> root = criteriaQuery.from(Course.class);

        criteriaQuery.select(root).where(builder.equal(root.get("courseNumber"), courseNumber));

        return entityManager.createQuery(criteriaQuery).getResultStream().findFirst().orElse(null);
    }
    @Override
    public List<Course> getCoursesForStudentInTerm(String studentNumber, Semester semester) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> query = cb.createQuery(Course.class);
        Root<Course> courseRoot = query.from(Course.class);
        Join<Course, CourseStudent> courseStudentJoin = courseRoot.join("courseStudents");
        Join<CourseStudent, Student> studentJoin = courseStudentJoin.join("student");

        Predicate studentNumberPredicate = cb.equal(studentJoin.get("studentNumber"), studentNumber);
        Predicate semesterPredicate = cb.equal(courseRoot.get("semester"), semester);

        query
                .select(courseRoot)
                .where(cb.and(studentNumberPredicate, semesterPredicate));

        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public List<Course> findAllByIds(List<Long> courseIds) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> query = cb.createQuery(Course.class);
        Root<Course> courseRoot = query.from(Course.class);

        query.select(courseRoot)
                .where(courseRoot.get("id").in(courseIds));

        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public List<Course> getCoursesByTeacherNumberAndSemester(String teacherNumber, Semester semester) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> query = cb.createQuery(Course.class);
        Root<Course> courseRoot = query.from(Course.class);

        Join<Course, Teacher> teacherJoin = courseRoot.join("teacher", JoinType.INNER);

        Predicate teacherNumberPredicate = cb.equal(teacherJoin.get("teacherNumber"), teacherNumber);
        Predicate semesterPredicate = cb.equal(courseRoot.get("semester"), semester);

        query.select(courseRoot)
                .where(cb.and(teacherNumberPredicate, semesterPredicate));

        return entityManager.createQuery(query).getResultList();
    }
}
