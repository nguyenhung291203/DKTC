package com.example.be.models.mapper;

import com.example.be.models.builder.StudentBuilder;
import com.example.be.models.entity.Student;

public class StudentMapper {
    public static StudentBuilder mapStudentToStudentBuilder(Student student) {
        return StudentBuilder.builder()
                .id(student.getId())
                .address(student.getAddress())
                .dateOfBirth(student.getDateOfBirth())
                .majorName(student.getMajor().getName())
                .name(student.getName())
                .build();
    }
}