package com.company.coursemanager.controller;

import com.company.coursemanager.model.Course;
import com.company.coursemanager.repository.CourseRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CourseController.class)
public class CourseControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    CourseRepository repo;

    ObjectMapper mapper = new ObjectMapper();



    private Course course;
    private String courseJson;
    private List<Course> allCourses = new ArrayList<>();
    private String allCoursesJson;

    @Before
    public void setUp() throws Exception {

        course = new Course();
        course.setId(101);
        course.setCourseNumber("101");
        course.setCourseTitle("DADA");
        course.setCourseInstructor("Lupin");
        course.setQuarter("Fall");

        courseJson = mapper.writeValueAsString(course);

        Course course1 = new Course();
        course1.setId(102);
        course1.setCourseNumber("102");
        course1.setCourseTitle("Potions");
        course1.setCourseInstructor("Snape");
        course1.setQuarter("Fall");

        allCourses.add(course);
        allCourses.add(course1);

        allCoursesJson = mapper.writeValueAsString(allCourses);
    }

    @Test
    public void shouldCreateCourse() throws Exception {
        Course input = new Course();
//        input.setId(1);
        input.setCourseNumber("101");
        input.setCourseTitle("DADA");
        input.setCourseInstructor("Lupin");
        input.setQuarter("Fall");


        String inputJson = mapper.writeValueAsString(input);

        given(repo.save(input)).willReturn(course);

        mockMvc.perform(
                post("/courses")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(courseJson));
    }

    @Test
    public void shouldGetAllCourses() throws Exception {

        given(repo.findAll()).willReturn(allCourses);

        mockMvc.perform(
                get("/courses"))
                .andExpect(status().isOk())
                .andExpect(content().json(allCoursesJson)
                );
    }

    @Test
    public void shouldGetCourseByCourseInstructor() throws Exception {

        given(repo.findCourseByCourseInstructor("Lupin")).willReturn(allCourses);

        mockMvc.perform(
                get("/courses/Lupin"))
                .andExpect(status().isOk())
                .andExpect(content().json(allCoursesJson)
                );

    }
}