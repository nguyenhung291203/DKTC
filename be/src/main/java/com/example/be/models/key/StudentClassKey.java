package com.example.be.models.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class StudentClassKey implements Serializable {
    @Column(name="class_id")
    private int classId;
    @Column(name="student_id")
    private int studentId;
}
