package com.example.be.service;

import com.example.be.models.entity.Point;
import com.example.be.models.key.PointKey;
import com.example.be.models.request.PointPayload;
import com.example.be.models.request.PointRequest;
import com.example.be.models.response.ResultResponse;

import java.util.List;

public interface PointService {
    List<Point> getAllPoints();
    List<Point> getListPointsByStudentId(String studentId);
    List<Point> getListPointsByCLassSubjectId(String classSubjectId);
    List<Point> getListPointsSubjectId(String subjectId);
    Point insertPoint(PointKey pointKey);
    Point editPointById(String studentId,String classesSubjectsId,PointRequest pointRequest);
    List<Point> editListPoint(List<PointPayload> pointPayloads);
    float getGpa(String studentId);
    ResultResponse getResultByStudentId(String studentId);
}