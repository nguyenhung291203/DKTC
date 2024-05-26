package com.example.be.models.response;

import com.example.be.models.entity.Unit;
import com.example.be.models.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserTeacherResponse {
    private String id;
    private String name;
    private Unit unit;
    private String position;
    private User user;
    private JwtAuthResponse jwtAuthResponse;
}
