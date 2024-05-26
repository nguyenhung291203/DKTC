package com.example.be.service;

import com.example.be.models.entity.Teacher;
import com.example.be.models.mapper.TeacherMapper;
import com.example.be.models.response.JwtAuthResponse;
import com.example.be.models.response.UserTeacherResponse;
import com.example.be.respository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    private TeacherRepository teacherRepository;
    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public UserTeacherResponse getTeacherByUsername(String username, JwtAuthResponse jwtAuthResponse) {
        Teacher teacher =  teacherRepository.getTeacherByUserName(username);
        return TeacherMapper.mapUserToUserTeacher(teacher,jwtAuthResponse);
    }
}
