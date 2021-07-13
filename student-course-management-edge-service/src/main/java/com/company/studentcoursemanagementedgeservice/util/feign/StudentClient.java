package com.company.studentcoursemanagementedgeservice.util.feign;

import com.company.studentcoursemanagementedgeservice.model.Course;
import com.company.studentcoursemanagementedgeservice.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "student-course-manager")
public interface StudentClient {

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student);

    @PutMapping(value ="/students/{id}")
    public void updateStudentById(@RequestBody Student student, @PathVariable Integer id);

    @DeleteMapping(value = "/students/{id}")
    public void deleteStudentById(@PathVariable Integer id);

    @GetMapping(value = "/students/{id}")
    public Student getStudentById(@PathVariable Integer id);

    @GetMapping("/students")
    public List<Student> getAllStudents();
}
