package com.devsenior.llavemaestra.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.devsenior.llavemaestra.dto.request.HerramientaRequest;
import com.devsenior.llavemaestra.dto.response.HerramientaResponse;
import com.devsenior.llavemaestra.models.Herramienta;

@Mapper(componentModel = "spring")
public interface HerramientaMapper {

  @Mapping(target = "id", ignore = true)
  Herramienta aEntidad(HerramientaRequest request);

  HerramientaResponse aResponse(Herramienta herramienta);

}
