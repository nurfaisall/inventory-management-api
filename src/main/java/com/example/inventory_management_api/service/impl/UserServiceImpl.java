package com.example.inventory_management_api.service.impl;

import com.example.inventory_management_api.dto.RegisterRequest;
import com.example.inventory_management_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void register(RegisterRequest registerRequest) {

    }
}
