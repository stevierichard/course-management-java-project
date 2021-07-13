package com.company.studentcoursemanagementedgeservice.util.feign;

import com.company.studentcoursemanagementedgeservice.model.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "course-manager")
public interface CourseClient {

    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course);

    @GetMapping("/courses")
    public List<Course> getAllCourses();

    @GetMapping(value = "/courses/{courseInstructor}")
    public List<Course> getCourseByCourseInstructor(@PathVariable String courseInstructor);

}
