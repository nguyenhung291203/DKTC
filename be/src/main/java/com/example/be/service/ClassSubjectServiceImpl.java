package com.example.be.service;
import com.example.be.models.entity.ClassSubject;
import com.example.be.respository.ClassSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassSubjectServiceImpl implements ClassSubjectService{
    @Autowired
    private ClassSubjectRepository classSubjectRepository;

    @Override
    public List<ClassSubject> getAllClassSubject() {
        return classSubjectRepository.findAll();
    }

    @Override
    public List<ClassSubject> getListClassSubjectByTeacherId(String teacherId) {
        return classSubjectRepository.getClassSubjectByTeacherId(teacherId);
    }

    @Override
    public List<ClassSubject> getClassSubjectByStudentId(String studentId) {
        return classSubjectRepository.getClassSubjectByStudentId(studentId);
    }
}
