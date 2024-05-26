package com.example.be.service;

import com.example.be.exception.UserNotFoundException;
import com.example.be.models.entity.Student;
import com.example.be.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getListStudentsByUniversityId(String universityId) {
        return studentRepository.getListStudentsByUniversityId(universityId);
    }

    @Override
    public Optional<Student> findStudentById(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> getListStudentsByClassSubjectId(String classSubjectId) {
        return studentRepository.getListStudentsByClassSubjectId(classSubjectId);
    }


}
