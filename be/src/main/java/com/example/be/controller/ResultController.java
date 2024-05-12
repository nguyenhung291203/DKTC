package com.example.be.controller;

import com.example.be.service.ResultService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/result")
@CrossOrigin(origins = "http://localhost:4200")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @GetMapping()
    public ResponseEntity<?> getListResult(){
        return ResponseEntity.ok(resultService.getListResult());
    }

    @GetMapping("/search")
    public ResponseEntity<?> getListResultByStudentId(@PathParam("student_id") int student_id){
        System.out.println(student_id);
        return ResponseEntity.ok(resultService.getListResultByStudentId(student_id));
    }

}
