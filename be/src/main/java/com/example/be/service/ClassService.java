package com.example.be.service;

import com.example.be.models.builder.ClassBuilder;
import com.example.be.models.builder.StudentBuilder;
import com.example.be.models.entity.Class;
import com.example.be.models.entity.Student;
import com.example.be.models.mapper.ClassMapper;
import com.example.be.models.mapper.StudentMapper;
import com.example.be.respository.ClassRepository;
import com.example.be.respository.StudentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private StudentClassRepository studentClassRepository;
    public List<ClassBuilder> getAllClasses() {
        List<Class> classes = classRepository.findAll();

        return classes.stream().map(item->getClassById(item.getId())).collect(Collectors.toList());
    }

    public List<ClassBuilder> getCLassByCodeCourse(String codeCourse){
        List<Class> classes;
        if (!codeCourse.isEmpty()) {
            classes = classRepository.findByCodeCourse(codeCourse);
        } else {
            classes = classRepository.findAll();
        }
        return classes.stream().map(item->getClassById(item.getId())).collect(Collectors.toList());
    }

    public ClassBuilder getClassById(int id) {
        Class classEntity = classRepository.findById(id).get();
        List<Student> students = studentClassRepository.findStudentsByClassId(id);
        List<StudentBuilder> studentBuilders = students.stream().map(StudentMapper::mapStudentToStudentBuilder).collect(Collectors.toList());
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
                .students(studentBuilders)
                .registered(studentBuilders.size())
                .codeCourse(classEntity.getCourse().getCodeCourse())
                .credit(classEntity.getCourse().getCredit())
                .build();
    }

    public List<ClassBuilder> getClassByStudentId(int id){
        List<Class> classes = studentClassRepository.findClassesByStudentId(id);
        return classes.stream().map(item->getClassById(item.getId())).collect(Collectors.toList());
    }

    public List<ClassBuilder> getClassByCourseName(String courseName) {
        List<Class> classes = classRepository.findByCourseName(courseName);
        return classes.stream().map(ClassMapper::mapClassToClassBuilder).collect(Collectors.toList());
    }



    public List<ClassBuilder> getClassByUsername(int id){
        List<Class> classes = classRepository.findByTeacherId(id);
        return classes.stream().map(ClassMapper::mapClassToClassBuilder).collect(Collectors.toList());
    }
}