package com.hibernate.mapping.service.Impl;

import com.hibernate.mapping.entity.Instructor;
import com.hibernate.mapping.exceptionInstructor.UserNotFoundException;
import com.hibernate.mapping.repository.InstructorRepo;
import com.hibernate.mapping.service.InstructorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepo instructorRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Instructor getInstructorById(int id) throws UserNotFoundException {

        Instructor instructor = this.instructorRepo.findById(id).orElseThrow(() ->
                new UserNotFoundException("invalid id : " + id));

        return instructor;

    }

    @Override
    public Instructor addInstructor(Instructor instructor) {

        Instructor savedInst = this.instructorRepo.save(instructor);
        return savedInst;
    }

    @Override
    public List<Instructor> getAllInstructor() {

        List<Instructor> allInstructor = this.instructorRepo.findAll();
        return allInstructor;
    }

    @Override
    public boolean deleteById(int id) {

        this.instructorRepo.deleteById(id);
        return true;

    }

    @Override
    public Instructor updateInstructor(Instructor instructor, int id) {

        Instructor instructor1 = this.instructorRepo.findById(id).get();

        instructor1.setEmail(instructor.getEmail());
        instructor1.setFirstName(instructor.getFirstName());
        instructor1.setLastName(instructor.getLastName());
        Instructor newInstructor = this.instructorRepo.save(instructor1);


        return newInstructor;

    }


}
