package com.example.be.models.response;

import com.example.be.models.entity.ClassStudent;
import com.example.be.models.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserStudentResponse {
    private String id;
    private String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateOfBirth;
    private ClassStudent classStudent;
    private User user;
    private JwtAuthResponse jwtAuthResponse;
}
