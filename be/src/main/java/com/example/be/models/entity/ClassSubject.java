package com.example.be.models.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="classes_subject")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClassSubject {
    @Id
    @Column(length = 10)
    private String id;
    private int size = 40;
    @Column(name="start_date")
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date startDate;

    @ManyToOne
    @JoinColumn(name = "subject_id",nullable = false)
    private Subject subject;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="teacher_id",nullable = false)
    private Teacher teacher;

    private int registered=0;

}
