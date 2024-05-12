package com.example.be.controller;

import com.example.be.models.builder.StudentBuilder;
import com.example.be.models.builder.StudentInfo;
import com.example.be.models.builder.StudentResultBuilder;
import com.example.be.models.entity.Student;
import com.example.be.service.StudentService;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping()
    public ResponseEntity<?> getListStudent(){
        return ResponseEntity.ok(studentService.getListStudent());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id){

        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/info")
    public ResponseEntity<?> getInfoStudent(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        StudentInfo student = studentService.getStudentInfo(username);
        return ResponseEntity.ok(student);
    }
}