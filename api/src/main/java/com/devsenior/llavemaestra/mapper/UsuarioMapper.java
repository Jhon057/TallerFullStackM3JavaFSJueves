package com.devsenior.llavemaestra.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.devsenior.llavemaestra.dto.request.UsuarioRequest;
import com.devsenior.llavemaestra.dto.response.UsuarioResponse;
import com.devsenior.llavemaestra.models.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "creadoEn", ignore = true)
  @Mapping(target = "password", ignore = true)

  Usuario aEntidad(UsuarioRequest request);

  UsuarioResponse aResponse(Usuario usuario);

}
