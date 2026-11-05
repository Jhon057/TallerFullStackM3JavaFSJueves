package com.devsenior.llavemaestra.services;

import java.util.List;

import com.devsenior.llavemaestra.dto.response.UsuarioResponse;

public interface UsuarioService {
  List<UsuarioResponse> listarUsuarios();

  UsuarioResponse cambiarEstado(Long id, boolean activo);
}
