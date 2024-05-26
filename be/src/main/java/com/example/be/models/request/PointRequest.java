package com.example.be.models.request;

import com.example.be.models.key.PointKey;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PointRequest {
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
    private float scoreNumberThree;
}
