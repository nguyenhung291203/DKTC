package com.example.be.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotBlank(message = "Không được phép để trống tài khoản")
    private String username;
    @NotBlank(message = "Không được phép để trống mật khẩu")
    private String password;
}