package com.example.be.service;

import com.example.be.models.entity.Course;
import com.example.be.respository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getListCourse(){
        return courseRepository.findAll();
    }
}
