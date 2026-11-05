package com.devsenior.llavemaestra.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.llavemaestra.dto.request.EstadoUsuarioRequest; // Usar el DTO correcto de usuario
import com.devsenior.llavemaestra.dto.response.UsuarioResponse;
import com.devsenior.llavemaestra.services.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

  private final UsuarioService service;

  @PreAuthorize("hasAuthority('CLIENTES_GESTIONAR')")
  @GetMapping
  public ResponseEntity<List<UsuarioResponse>> listarUsuarios() {
    return ResponseEntity.ok(service.listarUsuarios());
  }

  @PreAuthorize("hasAuthority('CLIENTES_GESTIONAR')")
  @PatchMapping("/{id}/estado")
  public ResponseEntity<UsuarioResponse> cambiarEstado(
      @PathVariable Long id,
      @RequestBody EstadoUsuarioRequest request) {
    return ResponseEntity.ok(service.cambiarEstado(id, request.isActivo()));
  }

}