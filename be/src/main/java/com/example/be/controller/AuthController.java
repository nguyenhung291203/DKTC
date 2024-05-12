package com.example.be.controller;

import com.example.be.jwt.JwtTokenProvider;
import com.example.be.models.entity.Role;
import com.example.be.models.entity.User;
import com.example.be.models.request.LoginRequest;
import com.example.be.models.response.JwtAuthResponse;
import com.example.be.service.AuthService;
import com.example.be.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;
    private JwtTokenProvider jwtTokenProvider;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try{
            String token = authService.login(loginRequest);
            String username = jwtTokenProvider.getUsername(token);
            List<Role> roles = userService.getListRole(username);
            JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
            jwtAuthResponse.setAccessToken(token);
            jwtAuthResponse.setRole(roles.get(0).getName());    
            return ResponseEntity.ok().body(jwtAuthResponse);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
        // Lấy thông tin xác thực hiện tại
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            // Đăng xuất và xóa thông tin xác thực
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        // Chuyển hướng về trang đăng nhập hoặc trang chủ
        return ResponseEntity.ok().body("{\"message\": \"Đăng xuất thành công\"}");
    }

}
