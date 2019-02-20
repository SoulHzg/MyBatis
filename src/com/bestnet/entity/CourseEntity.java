package com.bestnet.entity;

import java.util.List;

public class CourseEntity {
    private String id;
    private String name;
    private List<StudentEntity> studentList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentEntity> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentEntity> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "CourseEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
