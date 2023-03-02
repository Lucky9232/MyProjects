package com.hibernate.mapping.service;

import com.hibernate.mapping.entity.Course;
import com.hibernate.mapping.exceptionInstructor.UserNotFoundException;

import java.util.List;

public interface CourseService {
    Course getCourseById(int id) throws UserNotFoundException;

    List<Course> getAllCourse();

    boolean deleteCourseById(int id);

    Course updateCourse(Course course,Integer id);



}
