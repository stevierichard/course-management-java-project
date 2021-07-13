package com.company.studentcoursemanagementedgeservice.model;

import java.util.Objects;

/* @RefreshScope */
public class Course {

    private Integer id;
    private String courseNumber;
    private String courseTitle;
    private String courseInstructor;
    private String quarter;

    public Course() {
    }

    public Course(Integer id, String courseNumber, String courseTitle, String courseInstructor, String quarter) {
        this.id = id;
        this.courseNumber = courseNumber;
        this.courseTitle = courseTitle;
        this.courseInstructor = courseInstructor;
        this.quarter = quarter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) && Objects.equals(courseNumber, course.courseNumber) && Objects.equals(courseTitle, course.courseTitle) && Objects.equals(courseInstructor, course.courseInstructor) && Objects.equals(quarter, course.quarter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseNumber, courseTitle, courseInstructor, quarter);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseNumber='" + courseNumber + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseInstructor='" + courseInstructor + '\'' +
                ", quarter='" + quarter + '\'' +
                '}';
    }
}
