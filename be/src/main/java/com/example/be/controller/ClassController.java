package com.example.be.controller;

import com.example.be.service.ClassService;
import com.example.be.service.StudentClassService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.experimental.PackagePrivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/class")
@CrossOrigin(origins = "http://localhost:4200")
public class ClassController {
    @Autowired
    private ClassService classService;
    @Autowired
    private StudentClassService studentClassService;
    @GetMapping()
    public ResponseEntity<?> getListClasses(){
        return ResponseEntity.ok(classService.getAllClasses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClassById(@PathVariable int id){
        return ResponseEntity.ok(classService.getClassById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<?> getClassByCourseName(@RequestParam("name") String name){
        return ResponseEntity.ok(classService.getClassByCourseName(name));
    }

    @GetMapping("/search-by-student")
    public ResponseEntity<?> getClassByStudentId(@RequestParam("student_id") int id){
        return ResponseEntity.ok(classService.getClassByStudentId(id));
    }

    @GetMapping("/search-by-code-course")
    public ResponseEntity<?> getClassByCodeCourse(@RequestParam("code_course") String codeCourse){
        return ResponseEntity.ok(classService.getCLassByCodeCourse(codeCourse));
    }
}
