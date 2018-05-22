package com.tw.entity;

import java.util.ArrayList;

public class Student {
    String name;
    String StudentID;
    ArrayList<Course> studentCourse = new ArrayList<>();

    public Student(String name, String studentID, ArrayList<Course> studentCourse) {
        this.name = name;
        StudentID = studentID;
        this.studentCourse = studentCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public ArrayList<Course> getStudentCouse() {
        return studentCourse;
    }

    public void setStudentCouse(ArrayList<Course> studentCouse) {
        this.studentCourse = studentCouse;
    }
}
