package com.example.be.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name="marjors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Marjor {
    @Id
    private String id;
    @NotNull
    private String name;
    @ManyToOne
    @JoinColumn(name = "university_id",nullable = false)
    private University university;
//    @OneToMany(mappedBy = "marjor")
//    private Set<ClassStudent> classStudents;
}
