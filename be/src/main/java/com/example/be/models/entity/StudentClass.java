package com.example.be.models.entity;

import com.example.be.models.key.StudentClassKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students_classes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentClass {
    @EmbeddedId
    private StudentClassKey id;

    @ManyToOne
    @JoinColumn(name="student_id",insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name="class_id",insertable = false, updatable = false)
    private Class classEntity;
}
