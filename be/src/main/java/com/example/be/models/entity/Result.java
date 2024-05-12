package com.example.be.models.entity;

import com.example.be.models.key.ResultKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="results")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {
    @EmbeddedId
    private ResultKey id;

    @ManyToOne
    @JoinColumn(name="student_id",insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name="course_id",insertable = false, updatable = false)
    private Course course;

    @Column(name="score_number_one")
    private float scoreNumberOne;

    @Column(name="score_number_two")
    private float scoreNumberTwo;

    @Column(name="score_number_three")
    private float scoreNumberThree;

    @Column(name="score_total")
    private float scoreTotal;

    @Column(name = "score_letter")
    private String scoreLetter;
}
