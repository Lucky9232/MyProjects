package com.hibernate.mapping.contoller;

import com.hibernate.mapping.entity.Course;
import com.hibernate.mapping.exceptionInstructor.UserNotFoundException;
import com.hibernate.mapping.repository.CourseRepo;
import com.hibernate.mapping.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    public CourseService courseService;

    @Autowired
    private CourseRepo courseRepo;


    @GetMapping("{cId}")
    public ResponseEntity<Course> getAllCourse(@PathVariable("cId") int id) throws UserNotFoundException {

        Course courseById = this.courseService.getCourseById(id);
        return ResponseEntity.ok(courseById);
    }

    @GetMapping("/")
    public ResponseEntity<List<Course>> getAllCourse()
    {
        List<Course> allCourse = this.courseService.getAllCourse();
        return new ResponseEntity<>(allCourse,HttpStatus.OK);
    }


    @DeleteMapping("/delete/{dId}")
    public boolean deleteCourseId(@PathVariable("dId") int id)
    {
        this.courseService.deleteCourseById(id);
        return true;
    }

    @PutMapping("/update/{courId}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course,@PathVariable("courId") int id)
    {
        Course course1 = this.courseService.updateCourse(course,id);

        return new ResponseEntity<>(course1,HttpStatus.OK);
    }



}
