package com.example.be.models.builder;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResultBuilder {
    private int studentId;
    private String studentName;
    private String nameCourse;
    private String codeCourse;
    private float scoreNumberOne;
    private float scoreNumberTwo;
    private float scoreNumberThree;
    private float scoreTotal;
    private String scoreLetter;

}
