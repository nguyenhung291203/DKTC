package com.example.be.service;

import com.example.be.models.builder.ClassBuilder;
import com.example.be.models.builder.StudentBuilder;
import com.example.be.models.entity.Class;
import com.example.be.models.entity.Student;
import com.example.be.models.mapper.StudentMapper;
import com.example.be.models.request.RegisterCourse;
import com.example.be.respository.StudentClassRepository;
import com.example.be.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentClassService {
    @Autowired
    private StudentClassRepository studentClassRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassService classService;
    public List<?> getListClassByStudentId(int id) {
        List<Class> classes = studentClassRepository.findClassesByStudentId(id);

        return classes.stream().map(item -> {
//            List<Student> students = studentRepository.findStudentByClassId(item.getId());
            List<StudentBuilder> studentBuilders = classService.getClassById(item.getId()).getStudents();

            return ClassBuilder.builder()
                    .id(item.getId())
                    .className(item.getTeacher().getName())
                    .endDate(item.getEndDate())
                    .address(item.getAddress())
                    .size(item.getSize())
                    .time(item.getTime().getName())
                    .startDate(item.getStartDate())
                    .students(studentBuilders)
                    .courseName(item.getCourse().getName())
                    .build();
        }).collect(Collectors.toList());
    }
    public void insertStudentAndClass(RegisterCourse registerCourse){
        studentClassRepository.insertStudentAndClass(registerCourse.getStudentId(), registerCourse.getClassId());
    }
}
