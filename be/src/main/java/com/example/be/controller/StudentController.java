package com.example.be.controller;

import com.example.be.models.entity.Student;
import com.example.be.respository.PointRepository;
import com.example.be.service.StudentService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "http://localhost:4200")
@Validated
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    PointRepository pointRepository;
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable(value = "id") String id){
        Optional<Student> student = studentService.findStudentById(id);
        System.out.println(pointRepository.getGpaByStudentId(id));
        return student.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<?> getAllStudents(){
        List<Student> res = studentService.getAllStudents();
        return ResponseEntity.ok(res);
    }

    @GetMapping("searchListStudentByUniversityId")
    public ResponseEntity<?> searchListStudentByUniversityId(@RequestParam("university_id") String universityId){
        return ResponseEntity.ok(studentService.getListStudentsByUniversityId(universityId));
    }

    @GetMapping("listStudentByClassSubjectId/{id}")
    public ResponseEntity<?> getListStudentsByClassSubjectId(@PathVariable String id){
        return ResponseEntity.ok(studentService.getListStudentsByClassSubjectId(id));
    }
}
