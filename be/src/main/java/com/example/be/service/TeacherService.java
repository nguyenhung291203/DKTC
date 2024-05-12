package com.example.be.service;

import com.example.be.models.builder.ClassBuilder;
import com.example.be.models.builder.TeacherBuilder;
import com.example.be.models.builder.TeacherInfo;
import com.example.be.models.entity.Class;
import com.example.be.models.entity.Teacher;
import com.example.be.models.mapper.ClassMapper;
import com.example.be.models.mapper.TeacherMapper;
import com.example.be.respository.ClassRepository;
import com.example.be.respository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ClassRepository classRepository;
    public List<Teacher> getListTeacher(){
        return teacherRepository.findAll();
    }
    public Teacher getTeacherById(int id){
        return teacherRepository.findById(id).get();
    }
    public TeacherInfo getTeacherInfo(String username){
        Teacher teacher = teacherRepository.findTeacherByUserName(username);
        List<Class> classes = classRepository.findByTeacherId(teacher.getId());

        return TeacherInfo.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .majorName(teacher.getMajor().getName())
                .classes(classes.stream().map(classa->ClassMapper.mapClassToClassBuilder(classa)).collect(Collectors.toList()))
                .build();
    }
}