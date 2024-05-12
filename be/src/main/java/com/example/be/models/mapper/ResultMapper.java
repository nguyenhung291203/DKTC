package com.example.be.models.mapper;

import com.example.be.models.builder.ResultBuilder;
import com.example.be.models.builder.StudentResultBuilder;
import com.example.be.models.entity.Result;

public class ResultMapper {
    public static ResultBuilder mapResultToResultBuilder(Result result) {
        return ResultBuilder.builder().studentId(result.getStudent().getId()).nameCourse(result.getCourse().getName())
                .scoreNumberOne(result.getScoreNumberOne())
                .scoreNumberTwo(result.getScoreNumberTwo())
                .scoreNumberThree(result.getScoreNumberThree())
                .studentName(result.getStudent().getName())
                .scoreTotal(result.getScoreTotal())
                .scoreLetter(result.getScoreLetter())
                .codeCourse(result.getCourse().getCodeCourse())
                .build();
    }
    public static StudentResultBuilder mapResultToStudentResultBuilder(Result result){
        return StudentResultBuilder.builder()
                .codeCourse(result.getCourse().getCodeCourse())
                .nameCourse(result.getCourse().getName())
                .scoreNumberOne(result.getScoreNumberOne())
                .scoreNumberTwo(result.getScoreNumberTwo())
                .scoreNumberThree(result.getScoreNumberThree())
                .scoreTotal(result.getScoreTotal())
                .scoreLetter(result.getScoreLetter())
                .build();
    }
}
