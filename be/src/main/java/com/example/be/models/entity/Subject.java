package com.example.be.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="subjects")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Subject {
    @Id
    @Column(length = 10)
    private String id;
    @NotNull
    private String name;
    @NotNull
    private int credit;
    private int theory;
    private int practice;
    private boolean required = false;
//    @OneToMany(mappedBy = "subject")
//    private Set<ClassSubject> classSubjects;
}
