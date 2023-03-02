package com.hibernate.mapping.repository;

import com.hibernate.mapping.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepo extends JpaRepository<Instructor,Integer> {
}
