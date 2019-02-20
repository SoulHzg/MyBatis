package com.bestnet.imp;

import com.bestnet.entity.CourseEntity;

public interface CourseImp {
    public CourseEntity qryCourseById(int id);

    //collection嵌套
    public CourseEntity qryCourseAndListStudent(int id);

    //collection分步
    public CourseEntity qryCourseAndListStudent2(int id);
}