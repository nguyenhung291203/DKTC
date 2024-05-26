package com.example.be.service;

import com.example.be.models.entity.Teacher;
import com.example.be.models.response.JwtAuthResponse;
import com.example.be.models.response.UserTeacherResponse;

import java.util.List;


public interface TeacherService {
    List<Teacher> getAllTeachers();
    UserTeacherResponse getTeacherByUsername(String username, JwtAuthResponse jwtAuthResponse);
}
