package com.hibernate.mapping.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;


    @Column(name = "first_name")
    @NotEmpty(message = "this is required field")
    @NotNull(message = "this is not null field")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "this is required field")
    @NotNull(message = "this is not null field")
    private String lastName;

    @Column(name = "email")
    @Email(message = "this is not valid email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "instructor",targetEntity = Course.class)
    @JsonManagedReference
    private List<Course> courses = new ArrayList<>();


    public Instructor(String firstName, String lastName, String email) {
    }
}
