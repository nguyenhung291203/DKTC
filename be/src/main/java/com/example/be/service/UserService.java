package com.example.be.service;

import com.example.be.models.entity.Role;
import com.example.be.models.entity.User;
import com.example.be.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Role> getListRole(String username){
        return userRepository.findByUsername(username).get().getRoles().stream().toList();
    }
}
