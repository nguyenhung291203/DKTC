package com.example.be.service;

import com.example.be.exception.DataNotFoundException;
import com.example.be.jwt.JwtTokenProvider;
import com.example.be.models.entity.User;
import com.example.be.models.request.LoginRequest;
import com.example.be.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String login(LoginRequest loginRequest) throws Exception{

        Optional<User> userOptional  = userRepository.findByUsername(loginRequest.getUsername());
        if (userOptional .isEmpty())
            throw new DataNotFoundException("Tài khoản mật khẩu không chính xác");
        User user = userOptional.get();
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new DataNotFoundException("Tài khoản mật khẩu không chính xác");
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        return token;
    }
}


