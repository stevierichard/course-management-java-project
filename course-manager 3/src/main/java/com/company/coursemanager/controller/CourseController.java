package com.company.coursemanager.controller;

import com.company.coursemanager.model.Course;
import com.company.coursemanager.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody Course course) {
        return courseRepo.save(course);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @GetMapping(value = "/{courseInstructor}")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCourseByCourseInstructor(@PathVariable String courseInstructor){
        List <Course> courses = courseRepo.findCourseByCourseInstructor(courseInstructor);
        return courses;
    }

}
