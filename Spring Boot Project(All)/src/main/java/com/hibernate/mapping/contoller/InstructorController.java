package com.hibernate.mapping.contoller;


import com.hibernate.mapping.entity.Instructor;
import com.hibernate.mapping.exceptionInstructor.UserNotFoundException;
import com.hibernate.mapping.repository.InstructorRepo;
import com.hibernate.mapping.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private InstructorRepo instructorRepo;



    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable("id") int id) throws UserNotFoundException {
        return ResponseEntity.ok(this.instructorService.getInstructorById(id));

    }


    @PostMapping("/add")
    public ResponseEntity<Instructor> addInstructor(@Valid @RequestBody Instructor instructor )
    {
        Instructor instructor1 = this.instructorService.addInstructor(instructor);
        return new ResponseEntity<>(instructor1,HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Instructor>> getAllInstructor()
    {
        List<Instructor> allInstructor = this.instructorService.getAllInstructor();
        return new ResponseEntity<>(allInstructor,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{dId}")
    public boolean deleteById(@PathVariable("dId") int id)
    {
        this.instructorService.deleteById(id);
        return true;
    }

    @PutMapping("/update/{InstId}")
    public ResponseEntity<Instructor> updateInstructor(@RequestBody Instructor instructor,@PathVariable("InstId") int id)
    {
        Instructor instructor1 = this.instructorService.updateInstructor(instructor,id);
        return new ResponseEntity<>(instructor1,HttpStatus.OK);
    }
}
