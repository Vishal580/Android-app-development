package com.example.crudoperaationp12;


public class Student {
    private int id;
    private String studentName;
    public Student() {
    }
    Student(int id, String studentName) {
        this.id = id;
        this.studentName = studentName;
    }
    public void setID(int id) {
        this.id = id;
    }
    public int getID() {
        return this.id;
    }
    void setStudentName(String studentname) {
        this.studentName = studentname;
    }
    public String getStudentName() {
        return this.studentName;

    }
}