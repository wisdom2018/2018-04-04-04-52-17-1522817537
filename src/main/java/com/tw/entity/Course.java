package com.tw.entity;

import java.util.ArrayList;

public class Course {
    int   courseId;
    String courseName;
    ArrayList<Course> courses = new ArrayList<>();

    public Course() {
    }

    public Course(int courseId, String courseName) {     //studentID and courseId as the combined key
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public ArrayList<Course> setCourses(){
        Course math = new Course(001,"math");
        courses.add(math);
        Course chinese = new Course(002,"chinese");
        courses.add(chinese);
        Course english = new Course(003,"english");
        courses.add(english);
        Course programming = new Course(004,"programming");
        courses.add(programming);
        return courses;
    }
}
