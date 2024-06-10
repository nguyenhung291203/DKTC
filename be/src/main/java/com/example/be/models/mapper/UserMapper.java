package com.example.be.models.mapper;

import com.example.be.models.entity.Student;
import com.example.be.models.entity.Teacher;
import com.example.be.models.response.JwtAuthResponse;
import com.example.be.models.response.LoginResponse;
import com.example.be.models.response.UserStudentResponse;
import com.example.be.models.response.UserTeacherResponse;

import static java.util.stream.DoubleStream.builder;

public class UserMapper {
    public static UserTeacherResponse mapUserToUserTeacher(Teacher teacher, JwtAuthResponse jwtAuthResponse){
        return UserTeacherResponse
                .builder()
                .id(teacher.getId())
                .position(teacher.getPosition())
                .unit(teacher.getUnit())
                .name(teacher.getName())
                .jwtAuthResponse(jwtAuthResponse)
                .user(teacher.getUser())
                .build();
    }
    public static UserStudentResponse mapUserToUserStudent(Student student,JwtAuthResponse jwtAuthResponse){
        return UserStudentResponse
                .builder()
                .id(student.getId())
                .classStudent(student.getClassStudent())
                .dateOfBirth(student.getDateOfBirth())
                .jwtAuthResponse(jwtAuthResponse)
                .user(student.getUser())
                .name(student.getName())
                .build();
    }
}
