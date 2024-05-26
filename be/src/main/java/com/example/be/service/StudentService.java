package com.example.be.service;


import com.example.be.models.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    List<Student> getListStudentsByUniversityId(String universityId);
    Optional<Student> findStudentById(String id);
    List<Student> getListStudentsByClassSubjectId(String classSubjectId);
}
