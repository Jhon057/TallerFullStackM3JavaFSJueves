package com.devsenior.llavemaestra.services;

import java.util.List;
import java.util.Optional;

import com.devsenior.llavemaestra.dto.response.HerramientaDtoResponse;

public interface HerramientaService {

  List<HerramientaDtoResponse> listarHerramientas();

  Optional<HerramientaDtoResponse> buscarPorId(Long id);

  void cambiarEstadoHerramienta(Long id, boolean estado);

}
