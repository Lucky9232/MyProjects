package com.hibernate.mapping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "course")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "this field is not empty")
    @NotEmpty
    @Column(name = "title")
    private String title;

    @Column(name = "fee")
    private String fee;

    @ManyToOne(targetEntity = Instructor.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    @JsonBackReference
    private Instructor instructor;
}
