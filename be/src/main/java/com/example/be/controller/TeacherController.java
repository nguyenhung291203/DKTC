package com.example.be.controller;

import com.example.be.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teacher")
@CrossOrigin
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping()
    public ResponseEntity<?> getListTeacher() {
        return ResponseEntity.ok(teacherService.getListTeacher());
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getTeacherById(@PathVariable int id) {
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }

    @GetMapping("/info")
    private ResponseEntity<?> getTeacherInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return ResponseEntity.ok(teacherService.getTeacherInfo(username));
    }

}
