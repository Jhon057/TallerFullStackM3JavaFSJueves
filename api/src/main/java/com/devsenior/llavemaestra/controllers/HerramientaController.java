package com.devsenior.llavemaestra.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.llavemaestra.dto.request.HerramientaRequest;
import com.devsenior.llavemaestra.dto.response.HerramientaResponse;
import com.devsenior.llavemaestra.services.HerramientaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/herramientas")
@RequiredArgsConstructor

public class HerramientaController {

  private final HerramientaService service;

  @GetMapping
  @PreAuthorize("hasAuthority('HERRAMIENTAS_VER')")
  public ResponseEntity<List<HerramientaResponse>> listarHerramientas() {
    return ResponseEntity.ok(service.listarHerramientas());

  }

  @GetMapping("/{id}")
  @PreAuthorize("hasAuthority('HERRAMIENTAS_VER')")
  public ResponseEntity<HerramientaResponse> buscarPorId(@PathVariable Long id) {
    return ResponseEntity.ok(service.buscarPorId(id));
  }

  @PatchMapping("/{id}/estado")
  @PreAuthorize("hasAuthority('HERRAMIENTAS_GESTIONAR')")
  public ResponseEntity<HerramientaResponse> cambiarEstado(
      @PathVariable Long id,
      @RequestBody HerramientaRequest request) {
    return ResponseEntity.ok(service.cambiarEstado(id, request.isActiva()));
  }
}