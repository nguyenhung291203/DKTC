package com.example.be.models.builder;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Builder
public class StudentInfo {
    private int id;
    private String name;
    private String address;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth;
    private String majorName;
    private List<StudentResultBuilder> results;
    private int completed;
    private int debt;
    private float gpa;
}
