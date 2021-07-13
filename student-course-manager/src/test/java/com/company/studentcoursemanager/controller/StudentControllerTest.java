package com.company.studentcoursemanager.controller;

import com.company.studentcoursemanager.model.Student;
import com.company.studentcoursemanager.repository.StudentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    StudentRepository repo;

    ObjectMapper mapper = new ObjectMapper();

    private Student student;
    private String studentJson;
    private List<Student> allStudents = new ArrayList<>();
    private String allStudentsJson;

    @org.junit.Before
    public void setUp() throws Exception {

        student = new Student();
        student.setId(1);
        student.setCourseId(101);
        student.setFirstName("Harry");
        student.setLastName("Potter");
        student.setCourse("DADA");
        student.setGpa(4.0);
        student.setEmail("hp@gmail.com");

        studentJson = mapper.writeValueAsString(student);

        Student student1 = new Student();
        student1.setId(2);
        student1.setCourseId(102);
        student1.setFirstName("Ron");
        student1.setLastName("Weasley");
        student1.setCourse("Potions");
        student1.setGpa(4.0);
        student1.setEmail("ron@gmail.com");

        allStudents.add(student);
        allStudents.add(student1);

        allStudentsJson = mapper.writeValueAsString(allStudents);
    }

    @Test
    public void shouldCreateStudentOnPost() throws Exception {

        Student input = new Student();
//        input.setId(1);
        input.setCourseId(101);
        input.setFirstName("Harry");
        input.setLastName("Potter");
        input.setCourse("DADA");
        input.setGpa(4.0);
        input.setEmail("hp@gmail.com");

        String inputJson = mapper.writeValueAsString(input);

        given(repo.save(input)).willReturn(student);

        mockMvc.perform(
                post("/students")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(studentJson));
    }

    @Test
    public void shouldGetStudentById() throws Exception {

        Optional<Student> optionalStudent = Optional.of(student);
        given(repo.findById(1)).willReturn(optionalStudent);

        mockMvc.perform(
                get("/students/1"))
                .andExpect(status().isOk())
                .andExpect((content().json(studentJson))
                );
    }

    @Test
    public void shouldUpdateStudentById() throws Exception {

        Student input = new Student();
//        input.setId(1);
        input.setCourseId(101);
        input.setFirstName("Harry");
        input.setLastName("Potter");
        input.setCourse("DADA");
        input.setGpa(4.0);
        input.setEmail("hp@gmail.com");

        String inputJson = mapper.writeValueAsString(input);


        mockMvc.perform(
                put("/students/1")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteStudentById() throws Exception {
        mockMvc.perform(delete("/students/1")).andExpect(status().isNoContent());
    }
}