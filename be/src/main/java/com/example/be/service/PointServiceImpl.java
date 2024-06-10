package com.example.be.service;

import com.example.be.exception.DataIsDefinedException;
import com.example.be.models.entity.ClassSubject;
import com.example.be.models.entity.Point;
import com.example.be.models.entity.Student;
import com.example.be.models.key.PointKey;
import com.example.be.models.request.PointPayload;
import com.example.be.models.request.PointRequest;
import com.example.be.models.response.ResultResponse;
import com.example.be.respository.ClassSubjectRepository;
import com.example.be.respository.PointRepository;
import com.example.be.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PointServiceImpl implements PointService {
    @Autowired
    private PointRepository pointRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassSubjectRepository classSubjectRepository;

    @Override
    public List<Point> getAllPoints() {
        return pointRepository.findAll();
    }

    @Override
    public List<Point> getListPointsByStudentId(String studentId) {
        return pointRepository.getListPointsByStudentId(studentId);
    }

    @Override
    public List<Point> getListPointsByCLassSubjectId(String classSubjectId) {
        return pointRepository.getListPointsByClassSubjectId(classSubjectId);
    }

    @Override
    public List<Point> getListPointsSubjectId(String subjectId) {
        return pointRepository.getListPointsBySubjectId(subjectId);
    }

    @Override
    public Point insertPoint(PointKey pointKey) {
        Point point = new Point();
        point.setId(pointKey);
        Student student = studentRepository.findById(pointKey.getStudentId()).get();
        ClassSubject classSubject = classSubjectRepository.findById(pointKey.getClassesSubjectsId()).get();
        classSubject.setRegistered(classSubject.getRegistered() + 1);
        classSubjectRepository.save(classSubject);
        point.setStudent(student);
        point.setClassSubject(classSubject);
        return pointRepository.save(point);

    }

    @Override
    public Point editPointById(String studentId, String classesSubjectsId, PointRequest pointRequest) {
        Point point = new Point(pointRequest.getScoreNumberOne(), pointRequest.getScoreNumberTwo(), pointRequest.getScoreNumberThree());
        point.setId(new PointKey(studentId, classesSubjectsId));
        point.setActived(true);
        point.setStudent(studentRepository.findById(studentId).get());
        point.setClassSubject(classSubjectRepository.findById(classesSubjectsId).get());
        point.setStudied(true);
        return pointRepository.save(point);
    }

    @Override
    public List<Point> editListPoint(List<PointPayload> pointPayloads) {
        List<Point> res = new ArrayList<>();
        pointPayloads.forEach(pointItem -> {
            Point point = new Point(pointItem.getScoreNumberOne(), pointItem.getScoreNumberTwo(), pointItem.getScoreNumberThree());
            point.setStudent(studentRepository.findById(pointItem.getId().getStudentId()).get());
            point.setId(pointItem.getId());
            point.setActived(true);
            point.setStudied(true);
            res.add(point);
        });
        return pointRepository.saveAll(res);

    }

    @Override
    public float getGpa(String studentId) {
        return pointRepository.getGpaByStudentId(studentId);
    }

    @Override
    public ResultResponse getResultByStudentId(String studentId) {

        return new ResultResponse(pointRepository.getCompletedByStudentId(studentId), pointRepository.getDebtByStudentId(studentId), (float) Math.round(pointRepository.getGpaByStudentId(studentId) * 100) / 100);
    }


}
