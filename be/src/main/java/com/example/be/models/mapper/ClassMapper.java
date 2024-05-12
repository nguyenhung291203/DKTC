package com.example.be.models.mapper;

import com.example.be.models.builder.ClassBuilder;
import com.example.be.models.entity.Class;
import com.example.be.models.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

public class ClassMapper {
    public static ClassBuilder mapClassToClassBuilder(Class classEntity) {
//        List<Student> students = classEntity.getStudents().stream().toList();

        return ClassBuilder.builder()
                .teacherName(classEntity.getTeacher().getName())
                .startDate(classEntity.getStartDate())
                .className(classEntity.getName())
                .address(classEntity.getAddress())
                .size(classEntity.getSize())
                .id(classEntity.getId())
                .time(classEntity.getTime().getName())
                .endDate(classEntity.getEndDate())
                .courseName(classEntity.getCourse().getName())
//                .students(classEntity.getStudentClasses().stream().map(studentClass -> StudentMapper.mapStudentToStudentBuilder(studentClass.getStudent())).collect(Collectors.toList()))
                .build();
    }
}
