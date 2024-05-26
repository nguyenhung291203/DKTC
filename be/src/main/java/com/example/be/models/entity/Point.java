package com.example.be.models.entity;

import com.example.be.models.key.PointKey;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.context.annotation.Bean;

@Entity
@Table(name = "points")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Point {
    @EmbeddedId
    private PointKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;



    public Point(float scoreNumberOne, float scoreNumberTwo, float scoreNumberThree) {
        this.scoreNumberOne = scoreNumberOne;
        this.scoreNumberTwo = scoreNumberTwo;

        if (0.7 * scoreNumberOne + 0.3 * scoreNumberTwo >= 4) {
            this.scoreNumberThree = scoreNumberThree;
        } else {
            this.scoreNumberThree = 0;
        }

        float scoreTotal = (float) ((0.7 * scoreNumberOne + 0.3 * scoreNumberTwo) * 0.3 + 0.7 * scoreNumberThree);
        this.scoreTotal = scoreTotal;

        String scoreLetter = "";
        if (scoreTotal < 4) {
            scoreLetter = "F";
            this.scoreLaster = 0;
        }
        if (scoreTotal <= 10) {
            scoreLetter = "A+";
            this.scoreLaster = 4;
        } if (scoreTotal < 9) {
            scoreLetter = "A";
            this.scoreLaster = 3.7F;
        } if (scoreTotal < 8.5) {
            scoreLetter = "B+";
            this.scoreLaster = 3.5F;
        }  if (scoreTotal < 8) {
            scoreLetter = "B";
            this.scoreLaster = 3.0F;
        }  if (scoreTotal < 7) {
            scoreLetter = "C+";
            this.scoreLaster = 2.5F;
        }  if (scoreTotal < 6.5) {
            scoreLetter = "C";
            this.scoreLaster = 2.0F;
        }  if (scoreTotal < 5.5) {
            scoreLetter = "D";
            this.scoreLaster = 1.0F;
        }
        this.scoreLetter = scoreLetter;
        this.actived = true;
    }

    @ManyToOne
    @MapsId("classesSubjectsId")
    @JoinColumn(name = "classes_subjects_id")
    private ClassSubject classSubject;

    @Column(name = "score_number_one")
    private float scoreNumberOne;
    @Column(name = "score_number_two")
    private float scoreNumberTwo;
    @Column(name = "score_number_three")
    private float scoreNumberThree;

    @Column(name = "score_total")
    private float scoreTotal;
    @Column(name="score_laster")
    private float scoreLaster;
    @Column(name = "score_letter", length = 2)
    private String scoreLetter;
    private boolean actived = false;

}
