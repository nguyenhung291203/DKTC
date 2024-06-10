package com.example.be.service;

import com.example.be.models.entity.ClassSubject;

import java.util.List;

public interface ClassSubjectService {
    List<ClassSubject> getAllClassSubject();
    List<ClassSubject> getListClassSubjectByTeacherId(String teacherId);
    List<ClassSubject> getClassSubjectByStudentId(String studentId);
    ClassSubject getClassSubjectById(String id);
    List<ClassSubject> getClassSubjectBySubjectId(String subjectId);
}
