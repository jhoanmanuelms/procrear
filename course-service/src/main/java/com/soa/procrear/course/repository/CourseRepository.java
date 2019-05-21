package com.soa.procrear.course.repository;

import com.soa.procrear.course.model.Course;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByStudentCode(Integer studentCode);

    Course findByStudentCodeAndSubjectCode(Integer studentCode, String subjectCode);

    Integer countByStudentCodeAndSubjectCode(Integer studentCode, String subjectCode);
}
