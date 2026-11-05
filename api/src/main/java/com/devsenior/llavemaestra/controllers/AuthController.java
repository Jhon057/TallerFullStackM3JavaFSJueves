package com.devsenior.llavemaestra.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.llavemaestra.dto.request.LoginRequest;
import com.devsenior.llavemaestra.dto.request.RegistroRequest;
import com.devsenior.llavemaestra.dto.response.AuthResponse;
import com.devsenior.llavemaestra.services.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
  private final AuthService authService;

  @PostMapping("/registro")
  public ResponseEntity<AuthResponse> registrar(
      @Valid @RequestBody RegistroRequest request) {
    return ResponseEntity.ok(authService.registrar(request));
  }

  @PostMapping("/login")
  public ResponseEntity<AuthResponse> login(
      @Valid @RequestBody LoginRequest request) {
    return ResponseEntity.ok(authService.login(request));
  }
}
