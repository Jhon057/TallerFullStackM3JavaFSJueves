package com.devsenior.llavemaestra.services;

import com.devsenior.llavemaestra.dto.request.LoginRequest;
import com.devsenior.llavemaestra.dto.request.RegistroRequest;
import com.devsenior.llavemaestra.dto.response.AuthResponse;

public interface AuthService {
  AuthResponse login(LoginRequest request);

  AuthResponse registrar(RegistroRequest request);
}
