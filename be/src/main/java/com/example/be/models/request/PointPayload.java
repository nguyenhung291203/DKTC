package com.example.be.models.request;

import com.example.be.models.key.PointKey;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PointPayload {
    private PointKey id;
    @NotNull(message = "Score number one must not be null")
    @Positive(message = "Score number one must be a positive value")
    @Min(value = 0,message = "Không được để trống điểm quá trình")
    @Max(value = 10,message = "Không được để trống điểm quá trình")
    private float scoreNumberOne;
    @NotNull(message = "Score number two must not be null")
    @Positive(message = "Score number two must be a positive value")
    @Min(value = 0,message = "Không được để trống giữa kì")
    @Max(value = 10,message = "Không được để trống điểm giữa kì")
    private float scoreNumberTwo;
    @Min(value = 0,message = "Không được để trống giữa kì")
    @Max(value = 10,message = "Không được để trống điểm giữa kì")
    @NotNull(message = "Score number three must not be null")
    @Positive(message = "Score number three must be a positive value")
    private float scoreNumberThree;
}
