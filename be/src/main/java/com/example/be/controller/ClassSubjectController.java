package com.example.be.controller;

import com.example.be.service.ClassSubjectService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/class-subject")
@CrossOrigin(origins = "http://localhost:4200")
@Validated
public class ClassSubjectController {
    @Autowired
    private ClassSubjectService classSubjectService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getClassSubjectById(@PathVariable String id){
        return ResponseEntity.ok(classSubjectService.getClassSubjectById(id));
    }
    @GetMapping("/getAllClassSubjects")
    public ResponseEntity<?> getAllClassSubjects(){
        return ResponseEntity.ok(classSubjectService.getAllClassSubject());
    }

    @GetMapping("/searchListClassSubjectsByTeacherId/{teacherId}")
    public ResponseEntity<?> searchListClassSubjectsByTeacherId(@PathVariable String teacherId){
        return ResponseEntity.ok(classSubjectService.getListClassSubjectByTeacherId(teacherId));
    }

    @GetMapping("getListClassSubjectByStudentId/{id}")
    public ResponseEntity<?> getClassSubjectByStudentId(@PathVariable String id){
        return ResponseEntity.ok(classSubjectService.getClassSubjectByStudentId(id));
    }

    @GetMapping("/getClassSubjectBySubjectId")
    public ResponseEntity<?> getClassSubjectBySubjectId(@RequestParam(defaultValue = "") String subjectId){
        return ResponseEntity.ok(classSubjectService.getClassSubjectBySubjectId(subjectId));
    }
}
