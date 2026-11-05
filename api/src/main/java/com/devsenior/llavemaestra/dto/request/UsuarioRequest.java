package com.devsenior.llavemaestra.dto.request;

import com.devsenior.llavemaestra.enums.Rol;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequest {

  @NotNull(message = "El valor del campo nombre no puede ser vacío")
  private String nombre;

  @NotNull(message = "El valor del campo correo no puede ser vacío")
  private String email;
  private boolean activo = true;

  @NotNull(message = "El valor del nombre de usuario correo no puede ser vacío")
  private String username;

  @NotNull(message = "El valor del rol correo no puede ser vacío")
  private Rol rol;
}
