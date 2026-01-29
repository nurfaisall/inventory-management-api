package com.example.inventory_management_api.service.impl;

import com.example.inventory_management_api.dto.RegisterRequest;
import com.example.inventory_management_api.entity.Role;
import com.example.inventory_management_api.entity.User;
import com.example.inventory_management_api.repository.UserRepository;
import com.example.inventory_management_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void register(RegisterRequest registerRequest) {
        if(userRepository.findByUsername(registerRequest.getUsername()).isPresent()){
            throw new RuntimeException("User already exist");
        }

        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getUsername()));
        user.setRole(Role.STAFF);

        userRepository.save(user);
    }
}
