package com.example.be.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "classes_student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassStudent {
    @Id
    @Column(length = 10)
    private String id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "marjor_id",nullable = false)
    private Marjor marjor;
//    @OneToMany(mappedBy = "classStudent")
//    private Set<Student> students;
}
