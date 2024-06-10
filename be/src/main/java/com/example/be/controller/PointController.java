package com.example.be.controller;

import com.example.be.models.key.PointKey;
import com.example.be.models.request.InsertPointRequest;
import com.example.be.models.request.PointPayload;
import com.example.be.models.request.PointRequest;
import com.example.be.models.response.GpaResponse;
import com.example.be.service.PointService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/point")
@CrossOrigin
@Validated
public class PointController {
    @Autowired
    private PointService pointService;

    @GetMapping("getAllPoints")
    public ResponseEntity<?> getAllPoints() {
        return ResponseEntity.ok(pointService.getAllPoints());
    }

    @GetMapping("getPointsByStudentId/{studentId}")
    public ResponseEntity<?> getPointsByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(pointService.getListPointsByStudentId(studentId));
    }

    @GetMapping("getPointsByClassSubjectId/{classSubjectId}")
    public ResponseEntity<?> getPointsByClassSubjectId(@PathVariable String classSubjectId) {
        return ResponseEntity.ok(pointService.getListPointsByCLassSubjectId(classSubjectId));
    }

    @GetMapping("getPointsBySubjectId/{subjectId}")
    public ResponseEntity<?> getPointsBySubjectId(@PathVariable String subjectId) {
        return ResponseEntity.ok(pointService.getListPointsSubjectId(subjectId));
    }

    @PostMapping("insertPoint")
    public ResponseEntity<?> insertPoint(@Valid @RequestBody InsertPointRequest insertPointRequest) {
        try {
            return new ResponseEntity<>(pointService.insertPoint(
                    new PointKey(insertPointRequest.getStudentId(),
                            insertPointRequest.getClassesSubjectsId()))
                    , HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("editPoint/{studentId}/{classesSubjectsId}")
    public ResponseEntity<?> editPoint(@PathVariable String studentId, @PathVariable String classesSubjectsId, @Valid @RequestBody PointRequest pointRequest) {
        return new ResponseEntity<>(pointService.editPointById(studentId, classesSubjectsId, pointRequest), HttpStatus.CREATED);
    }
    @PostMapping("editListPoint")
    public ResponseEntity<?> editListPoint(@RequestBody List<PointPayload> pointPayloads) {
        return new ResponseEntity<>(pointService.editListPoint(pointPayloads),HttpStatus.CREATED);
    }

    @GetMapping("result/{studentId}")
    public ResponseEntity<?> getResultByStudentId(@PathVariable String studentId){
        return ResponseEntity.ok(pointService.getResultByStudentId(studentId));
    }
}
