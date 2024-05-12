package com.example.be.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int credit;
    @Column(name="code_course")
    private String codeCourse;

    @OneToMany(mappedBy = "course")
    private Set<Result> results;

    @OneToMany(mappedBy = "course")
    private Set<Class> classes;
}
