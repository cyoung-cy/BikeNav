package com.example.bikenavbackend.controller;

import com.example.bikenavbackend.dto.request.LoginRequest;
import com.example.bikenavbackend.dto.request.RegisterRequest;
import com.example.bikenavbackend.dto.response.ApiResponse;
import com.example.bikenavbackend.dto.response.LoginData;
import com.example.bikenavbackend.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // 1.1 회원 가입
    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody @Valid RegisterRequest request) {
        try {
            authService.register(request);
            return ResponseEntity.ok(new ApiResponse(true, "회원가입 성공"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new ApiResponse(false, "회원가입 실패"));
        }
    }

    // 1.2 로그인
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody @Valid LoginRequest request) {
        try {
            LoginData data = authService.login(request);
            return ResponseEntity.ok(new ApiResponse(true, "로그인 성공", data));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body(new ApiResponse(false, e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new ApiResponse(false, "로그인 실패"));
        }
    }
}
