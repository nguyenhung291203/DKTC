package com.example.be.models.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ResultKey implements Serializable {
    @Column(name="student_id")
    private int studentId;
    @Column(name="course_id")
    private int courseId;
}
