package com.hibernate.mapping.repository;

import com.hibernate.mapping.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Integer> {
}
