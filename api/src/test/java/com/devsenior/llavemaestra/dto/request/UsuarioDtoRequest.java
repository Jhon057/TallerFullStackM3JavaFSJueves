package com.devsenior.llavemaestra.dto.request;

import com.devsenior.llavemaestra.enums.Rol;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDtoRequest {

  @NotBlank(message = "El valor de nombre no puede estar vacío")
  private String nombre;

  @NotBlank(message = "El valor de correo no puede estar vacío")
  private String email;

  @NotBlank(message = "El valor de contraseña no puede estar vacío")
  private String password;

  @NotNull(message = "El valor de rol no puede estar vacío")
  private Rol rol;

}
