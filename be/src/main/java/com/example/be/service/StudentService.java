package com.example.be.service;

import com.example.be.models.builder.StudentBuilder;
import com.example.be.models.builder.StudentInfo;
import com.example.be.models.builder.StudentResultBuilder;
import com.example.be.models.entity.Result;
import com.example.be.models.entity.Student;
import com.example.be.models.mapper.ResultMapper;
import com.example.be.models.mapper.StudentMapper;
import com.example.be.respository.ResultRepository;
import com.example.be.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ResultRepository resultRepository;

    public List<StudentBuilder> getListStudent() {
        return studentRepository.findAll().stream().map(student -> StudentMapper.mapStudentToStudentBuilder(student)).collect(Collectors.toList());
    }

    public StudentBuilder getStudentById(int id) {
        return StudentMapper.mapStudentToStudentBuilder(studentRepository.findById(id).get());
    }

    public List<StudentBuilder> getListStudentByClassId(int id) {
        return studentRepository.findStudentByClassId(id).stream().map(StudentMapper::mapStudentToStudentBuilder).collect(Collectors.toList());
    }

    public StudentInfo getStudentInfo(String username) {
        Student student = studentRepository.findStudentByUserName(username);
        StudentBuilder studentBuilder = StudentMapper.mapStudentToStudentBuilder(student);
        List<Result> results = resultRepository.findByStudentId(student.getId());
        int completed = resultRepository.countCompleted(student.getId());
        float gpa = resultRepository.gpa(student.getId());
        List<StudentResultBuilder> res = results.stream().map(result -> ResultMapper.mapResultToStudentResultBuilder(result)).collect(Collectors.toList());
        return StudentInfo.builder()
                .name(studentBuilder.getName())
                .majorName(studentBuilder.getMajorName())
                .dateOfBirth(studentBuilder.getDateOfBirth())
                .address(studentBuilder.getAddress())
                .id(student.getId())
                .results(res)
                .completed(completed)
                .debt(res.size() - completed)
                .gpa(gpa)
                .build();
    }
}
