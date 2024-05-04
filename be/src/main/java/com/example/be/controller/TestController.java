package com.example.be.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@CrossOrigin
public class TestController {
    @GetMapping()
    public ResponseEntity<String> get(){
        HttpHeaders headers = new HttpHeaders();
        System.out.println(headers.get("Authorization"));
        return ResponseEntity.ok().body("{\"message\": \"Test success\"}");
    }
}
