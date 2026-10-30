package com.devsenior.llavemaestra.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.devsenior.llavemaestra.dto.request.HerramientaDtoRequest;
import com.devsenior.llavemaestra.dto.response.HerramientaDtoResponse;
import com.devsenior.llavemaestra.models.Herramienta;

@Mapper(componentModel = "spring")
public interface HerramientaMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "activa", ignore = true)
  Herramienta aEntidad(HerramientaDtoRequest request);

  HerramientaDtoResponse aDto(Herramienta herramienta);

}
