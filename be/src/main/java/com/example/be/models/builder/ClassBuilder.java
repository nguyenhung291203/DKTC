package com.example.be.models.builder;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Builder
public class ClassBuilder {
    private int id;
    private String className;
    private String address;
    private String teacherName;
    private String courseName;
    private String time;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date startDate;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date endDate;
    private int size;
    private int registered;
    private List<StudentBuilder> students;
    private String codeCourse;
    private int credit;
}
