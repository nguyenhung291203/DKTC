package com.example.be.controller;

import com.example.be.service.TeacherService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/teacher")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @GetMapping("/getAllTeachers")
    public ResponseEntity<?> getAllTeachers(){
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }
}
