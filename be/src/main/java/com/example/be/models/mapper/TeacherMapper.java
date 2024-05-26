package com.example.be.models.mapper;

import com.example.be.models.entity.Teacher;
import com.example.be.models.entity.User;
import com.example.be.models.response.JwtAuthResponse;
import com.example.be.models.response.UserTeacherResponse;

public class TeacherMapper {
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
}
