package com.devsenior.llavemaestra.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.llavemaestra.dto.response.UsuarioDtoResponse;
import com.devsenior.llavemaestra.enums.Rol;
import com.devsenior.llavemaestra.mapper.UsuarioMapper;
import com.devsenior.llavemaestra.models.Usuario;
import com.devsenior.llavemaestra.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

  private final UsuarioRepository usuarioRepository;
  private final UsuarioMapper usuarioMapper;

  @Override
  public List<UsuarioDtoResponse> listarTodos() {
    return usuarioRepository.findAll().stream().map(usuarioMapper::aDto).toList();
  }

  @Override
  public void cambiarEstadoUsuario(Long id, boolean estado) {
    Usuario usuario = usuarioRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No hay registro con el id: " + id));
    if (!estado && usuario.getRol() == Rol.ADMIN) {
      throw new RuntimeException("El administrador no puede bloquearse a sí mismo");
    }
    usuario.setActivo(estado);
    usuarioRepository.save(usuario);
  }

  @Override
  public UsuarioDtoResponse buscarPorCorreo(String correo) {
    return usuarioRepository.findByEmail(correo).map(usuarioMapper::aDto).orElse(null);
  }

}
