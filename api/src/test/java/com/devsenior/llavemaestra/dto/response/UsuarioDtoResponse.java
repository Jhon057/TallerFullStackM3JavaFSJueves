package com.devsenior.llavemaestra.dto.response;

import java.time.LocalDateTime;

import com.devsenior.llavemaestra.enums.Rol;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDtoResponse {

  private String nombre;
  private String email;
  private Rol rol;
  private boolean activo;
  private LocalDateTime creadoEn;
}
