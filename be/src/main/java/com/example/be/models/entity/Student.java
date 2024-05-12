package com.example.be.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne
    @JoinColumn(name = "major_id", referencedColumnName = "id")
    private Major major;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Result> results;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<StudentClass> studentClasses;
}
