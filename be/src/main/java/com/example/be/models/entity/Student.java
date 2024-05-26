package com.example.be.models.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @Column(length = 8)
    private String id;
    private String name;
    @Column(name="date_of_birth")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateOfBirth;
    @ManyToOne
    @JoinColumn(name="class_student_id",nullable = false)
    private ClassStudent classStudent;
    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;



}
