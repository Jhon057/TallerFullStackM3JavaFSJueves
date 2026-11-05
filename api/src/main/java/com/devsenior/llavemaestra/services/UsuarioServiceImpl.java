package com.devsenior.llavemaestra.services;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.devsenior.llavemaestra.dto.response.UsuarioResponse;
import com.devsenior.llavemaestra.exceptions.ConflictoException;
import com.devsenior.llavemaestra.exceptions.RecursoNoEncontradoException;
import com.devsenior.llavemaestra.mapper.UsuarioMapper;
import com.devsenior.llavemaestra.models.Usuario;
import com.devsenior.llavemaestra.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

  private final UsuarioRepository repository;
  private final UsuarioMapper mapper;

  @Override
  public List<UsuarioResponse> listarUsuarios() {
    return repository.findAll().stream().map(mapper::aResponse).toList();
  }

  @Override
  public UsuarioResponse cambiarEstado(Long id, boolean activo) {
    Usuario usuario = repository.findById(id)
        .orElseThrow(() -> new RecursoNoEncontradoException("Usuario no encontrado con ID: " + id));

    org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String emailAdminActual = auth.getName();

    if (usuario.getEmail().equals(emailAdminActual) && !activo) {
      throw new ConflictoException("Un administrador no puede bloquear su propia cuenta.");
    }

    usuario.setActivo(activo); // Actualizar el estado
    Usuario usuarioGuardado = repository.save(usuario);

    return mapper.aResponse(usuarioGuardado);
  }

}
