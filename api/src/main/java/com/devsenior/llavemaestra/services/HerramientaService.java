package com.devsenior.llavemaestra.services;

import java.util.List;

import com.devsenior.llavemaestra.dto.response.HerramientaResponse;

public interface HerramientaService {

  List<HerramientaResponse> listarHerramientas();

  HerramientaResponse buscarPorId(long id);

  HerramientaResponse cambiarEstado(Long id, boolean activa);
}
