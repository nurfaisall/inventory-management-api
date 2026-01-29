package com.example.inventory_management_api.service;

import com.example.inventory_management_api.dto.LoginRequest;
import com.example.inventory_management_api.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
}
