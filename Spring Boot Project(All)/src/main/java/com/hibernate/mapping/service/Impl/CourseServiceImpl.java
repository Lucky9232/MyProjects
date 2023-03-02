package com.hibernate.mapping.service.Impl;

import com.hibernate.mapping.entity.Course;
import com.hibernate.mapping.entity.Instructor;
import com.hibernate.mapping.exceptionInstructor.UserNotFoundException;
import com.hibernate.mapping.repository.CourseRepo;
import com.hibernate.mapping.repository.InstructorRepo;
import com.hibernate.mapping.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private InstructorRepo instructorRepo;

    @Override
    public Course getCourseById(int id) throws UserNotFoundException {
        Course course = this.courseRepo.findById(id).orElseThrow(() ->
                new UserNotFoundException("invalid id : " + id));

        return course;

    }

    @Override
    public List<Course> getAllCourse() {

        List<Course> allCourse = this.courseRepo.findAll();
       return allCourse;

    }

    @Override
    public boolean deleteCourseById(int id) {
        this.courseRepo.deleteById(id);
        return true;

    }

    @Override
    public Course updateCourse(Course course, Integer id) {


        Course courseObj = this.courseRepo.findById(id).get();

        courseObj.setTitle(course.getTitle());
        courseObj.setFee(course.getFee());

        Course updatedCourse = this.courseRepo.save(courseObj);


        return updatedCourse;

    }

}
