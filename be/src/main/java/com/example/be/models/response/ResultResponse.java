package com.example.be.models.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResultResponse {
    private int completed;
    private int debt;
    private float gpa;

}
