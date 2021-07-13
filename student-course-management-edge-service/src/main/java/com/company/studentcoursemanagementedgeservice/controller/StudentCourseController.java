package com.company.studentcoursemanagementedgeservice.controller;

import com.company.studentcoursemanagementedgeservice.model.Course;
import com.company.studentcoursemanagementedgeservice.model.Student;
import com.company.studentcoursemanagementedgeservice.util.feign.CourseClient;
import com.company.studentcoursemanagementedgeservice.util.feign.StudentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studentCourse")
public class StudentCourseController {

    @Autowired
    private StudentClient studentClient;

    @Autowired
    private CourseClient courseClient;

    @RequestMapping(value="/students", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        return studentClient.createStudent(student);
    }

    @GetMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudents() {
        return studentClient.getAllStudents();

    }

    @GetMapping(value = "/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudentById(@PathVariable Integer id) {
        Optional<Student> student = Optional.ofNullable(studentClient.getStudentById(id));
        return student.get();
    }

    @RequestMapping(value ="/students/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStudentById(@RequestBody Student student, @PathVariable Integer id) {
        if(student.getId() == null) {
            student.setId(id);
        }
        /*check this in future */
        studentClient.updateStudentById(student, id);
            }

    @DeleteMapping(value = "/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentById(@PathVariable Integer id) {
        Student student = new Student();
        if(student.getId() == null) {
            student.setId(id);
        }
        studentClient.deleteStudentById(id);
    }

    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody Course course) {
        return courseClient.createCourse(course);
    }

    @GetMapping("/courses")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getAllCourses() {
        return courseClient.getAllCourses();

    }

    @GetMapping(value = "/courses/{courseInstructor}")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCourseByCourseInstructor(@PathVariable String courseInstructor){
        List <Course> courses = courseClient.getCourseByCourseInstructor(courseInstructor);
        return courses;
    }


}
