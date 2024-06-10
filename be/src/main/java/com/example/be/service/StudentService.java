package com.example.be.service;


import com.example.be.models.entity.Student;
import com.example.be.models.response.JwtAuthResponse;
import com.example.be.models.response.UserStudentResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    List<Student> getListStudentsByUniversityId(String universityId);
    Optional<Student> findStudentById(String id);
    List<Student> getListStudentsByClassSubjectId(String classSubjectId);
    UserStudentResponse getStudentByUsername(String username, JwtAuthResponse jwtAuthResponse);
}
