package com.devsenior.llavemaestra.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.llavemaestra.dto.response.HerramientaResponse;
import com.devsenior.llavemaestra.exceptions.RecursoNoEncontradoException;
import com.devsenior.llavemaestra.mapper.HerramientaMapper;
import com.devsenior.llavemaestra.models.Herramienta;
import com.devsenior.llavemaestra.repositories.HerramientaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HerramientaServiceImpl implements HerramientaService {

  private final HerramientaRepository repository;
  private final HerramientaMapper mapper;

  @Override
  public List<HerramientaResponse> listarHerramientas() {
    return repository.findAll().stream().map(mapper::aResponse).toList();
  }

  @Override
  public HerramientaResponse buscarPorId(long id) {
    return repository.findById(id).map(mapper::aResponse).orElse(null);
  }

  @Override
  public HerramientaResponse cambiarEstado(Long id, boolean activa) {
    Herramienta herramienta = repository.findById(id)
        .orElseThrow(() -> new RecursoNoEncontradoException("Herramienta no encontrada con ID: " + id));

    herramienta.setActiva(activa);
    Herramienta actualizada = repository.save(herramienta);
    return mapper.aResponse(actualizada);
  }
}
