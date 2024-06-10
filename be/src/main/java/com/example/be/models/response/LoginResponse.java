package com.example.be.models.response;

import com.example.be.models.entity.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginResponse<T>{
    private T position;
    private User user;
    private JwtAuthResponse jwtAuthResponse;
}
