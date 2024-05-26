package com.example.be.models.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class PointKey implements Serializable {
    @Column(name="student_id")
    @NotNull(message = "Mã sinh viên không được để trống")
    private String studentId;
    @Column(name = "classes_subjects_id")
    @NotNull(message = "Mã lớp môn học không được để trống")
    private String classesSubjectsId;
}
