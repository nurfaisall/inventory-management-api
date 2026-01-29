package com.example.inventory_management_api.controller;

import com.example.inventory_management_api.dto.LoginRequest;
import com.example.inventory_management_api.dto.LoginResponse;
import com.example.inventory_management_api.dto.RegisterRequest;
import com.example.inventory_management_api.service.AuthService;
import com.example.inventory_management_api.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @GetMapping("/")
    public String test(){
        System.out.println("berhasil");
        return "test berhasil";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest registerRequest){
        userService.register(registerRequest);

        return ResponseEntity.ok("User Telah berhasil di buat");

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest){

        return ResponseEntity.ok(authService.login(loginRequest));
    }

}
