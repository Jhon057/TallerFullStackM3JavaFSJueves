package com.devsenior.llavemaestra.services;

import java.util.List;

import com.devsenior.llavemaestra.dto.response.UsuarioDtoResponse;

public interface UsuarioService {

  List<UsuarioDtoResponse> listarTodos();

  void cambiarEstadoUsuario(Long id, boolean estado);

  UsuarioDtoResponse buscarPorCorreo(String correo);
}
