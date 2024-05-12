package com.example.be.controller;

import com.example.be.models.request.RegisterCourse;
import com.example.be.service.StudentClassService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/register-course")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentClassController {
    @Autowired
    private StudentClassService studentClassService;

    @PostMapping()
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<?> registerCourse(@RequestBody RegisterCourse registerCourse){
        try{
            studentClassService.insertStudentAndClass(registerCourse);
            return ResponseEntity.ok("{\"message\": \"Chèn thành công\"}");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
