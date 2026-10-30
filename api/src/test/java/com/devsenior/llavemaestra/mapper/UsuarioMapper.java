package com.devsenior.llavemaestra.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.devsenior.llavemaestra.dto.request.UsuarioDtoRequest;
import com.devsenior.llavemaestra.dto.response.UsuarioDtoResponse;
import com.devsenior.llavemaestra.models.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "activo", ignore = true)
  @Mapping(target = "creadoEn", ignore = true)
  Usuario aEntidad(UsuarioDtoRequest request);

  UsuarioDtoResponse aDto(Usuario usuario);
}
