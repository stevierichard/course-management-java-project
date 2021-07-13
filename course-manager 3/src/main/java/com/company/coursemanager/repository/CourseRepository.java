package com.company.coursemanager.repository;

import com.company.coursemanager.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository <Course, Integer> {

    List<Course> findCourseByCourseInstructor(String courseInstructor);
}
