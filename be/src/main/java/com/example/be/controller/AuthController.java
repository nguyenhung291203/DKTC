package com.example.be.controller;

import com.example.be.jwt.JwtTokenProvider;
import com.example.be.models.entity.Role;
import com.example.be.models.request.LoginRequest;
import com.example.be.models.response.JwtAuthResponse;
import com.example.be.service.AuthService;
import com.example.be.service.StudentService;
import com.example.be.service.TeacherService;
import com.example.be.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
@Validated
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    private JwtTokenProvider jwtTokenProvider;
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        try{
            String token = authService.login(loginRequest);
            String username = jwtTokenProvider.getUsername(token);
            List<Role> roles = userService.getListRole(username);
            JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
            jwtAuthResponse.setAccessToken(token);
            jwtAuthResponse.setRole(roles.get(0).getName());
            if (jwtAuthResponse.getRole().equals("ROLE_TEACHER")||jwtAuthResponse.getRole().equals("ROLE_ADMIN"))
                return ResponseEntity.ok().body(teacherService.getTeacherByUsername(username,jwtAuthResponse));
            if (jwtAuthResponse.getRole().equals("ROLE_STUDENT")){
                return ResponseEntity.ok().body(studentService.getStudentByUsername(username,jwtAuthResponse));
            }
            return null;
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
