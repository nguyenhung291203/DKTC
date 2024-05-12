package com.example.be.models.builder;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class TeacherInfo {
    private int id;
    private String name;
    private String majorName;
    private List<ClassBuilder> classes;
}
