package com.devsenior.llavemaestra.dto.response;

import java.time.LocalDateTime;

import com.devsenior.llavemaestra.enums.Rol;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse {

  private Long id;

  private String nombre;

  private String email;

  private boolean activo;

  private LocalDateTime creadoEn;

  private String username;

  private Rol rol;

}
