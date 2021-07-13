package com.company.studentcoursemanagementedgeservice.model;

import java.util.Objects;

public class Student {

    private Integer id;
    private Integer courseId;
    private String firstName;
    private String lastName;
    private String course;
    private double gpa;
    private String email;

    public Student() {
    }

    public Student(Integer id, Integer courseId, String firstName, String lastName, String course, double gpa, String email) {
        this.id = id;
        this.courseId = courseId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.gpa = gpa;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.gpa, gpa) == 0 && Objects.equals(id, student.id) && Objects.equals(courseId, student.courseId) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(course, student.course) && Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, firstName, lastName, course, gpa, email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", course='" + course + '\'' +
                ", gpa=" + gpa +
                ", email='" + email + '\'' +
                '}';
    }
}
