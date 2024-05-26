package com.example.be.models.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InsertPointRequest {
    @NotBlank(message = "Mã sinh viên không được để trống")
    private String studentId;
    @NotBlank(message = "Mã lớp môn học không được để trống")
    private String classesSubjectsId;
}
