package com.example.login.controller;

import com.example.login.dto.LoginRequest;
import com.example.login.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@Tag(name = "Authentication", description = "Login va ro'yxatdan o'tish")
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/login")
    @Operation(summary = "Tizimga kirish", description = "Username va parolni tekshiradi")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Muvaffaqiyatli kirdi"),
        @ApiResponse(responseCode = "401", description = "Login yoki parol noto'g'ri")
    })
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        boolean success = service.login(request.getUsername(), request.getPassword());
        if (success) {
            return ResponseEntity.ok("Tizimga muvaffaqiyatli kirdingiz!");
        } else {
            return ResponseEntity.status(401).body("Login yoki parol noto'g'ri");
        }
    }

    @PostMapping("/register")
    @Operation(summary = "Ro'yxatdan o'tish", description = "Yangi foydalanuvchi qo'shadi")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Foydalanuvchi yaratildi"),
        @ApiResponse(responseCode = "400", description = "Bu username band")
    })
    public ResponseEntity<String> register(@RequestBody LoginRequest request) {
        boolean created = service.register(request.getUsername(), request.getPassword());
        if (created) {
            return ResponseEntity.status(201).body("Ro'yxatdan o'tdingiz!");
        } else {
            return ResponseEntity.status(400).body("Bu username band");
        }
    }
}
