package com.hibernate.mapping.service;

import com.hibernate.mapping.entity.Instructor;
import com.hibernate.mapping.exceptionInstructor.UserNotFoundException;

import java.util.List;

public interface InstructorService {
    Instructor getInstructorById(int id) throws UserNotFoundException;

    Instructor addInstructor(Instructor instructor);

    List<Instructor> getAllInstructor();

    boolean deleteById(int id);

    Instructor updateInstructor(Instructor instructor,int id);


}
