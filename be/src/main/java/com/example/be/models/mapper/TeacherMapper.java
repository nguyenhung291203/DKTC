package com.example.be.models.mapper;

import com.example.be.models.builder.TeacherBuilder;
import com.example.be.models.builder.TeacherInfo;
import com.example.be.models.entity.Teacher;

import java.util.stream.Collectors;

public class TeacherMapper {
    public static TeacherBuilder mapTeacherToTeacherBuilder(Teacher teacher) {
        return TeacherBuilder.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .majorName(teacher.getMajor().getName())
                .build();
    }

    public static TeacherInfo mapTeacherToTeacherInfo(Teacher teacher){
        return TeacherInfo.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .majorName(teacher.getMajor().getName())
                .classes(teacher.getClasses().stream().map(aClass -> ClassMapper.mapClassToClassBuilder(aClass)).collect(Collectors.toList()))
                .build();
    }
}
