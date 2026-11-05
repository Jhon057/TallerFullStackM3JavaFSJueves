package com.devsenior.llavemaestra.dto.request;

import java.math.BigDecimal;

import com.devsenior.llavemaestra.enums.Categoria;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HerramientaRequest {

  @NotEmpty(message = "el valor de nombre no puede ser vacío")
  private String nombre;

  @NotNull(message = "el valor de categoría no puede ser vacío")
  private Categoria categoria;

  @NotEmpty(message = "el valor de descripción no puede ser vacío")
  private String descripcion;

  @NotNull(message = "el valor de precio día no puede ser vacío")
  private BigDecimal precioDia;

  @NotNull(message = "el valor de deposito día no puede ser vacío")
  private BigDecimal deposito;

  @NotNull(message = "el valor de unidades día no puede ser vacío")
  private Integer unidades;

  @NotEmpty(message = "el valor de imagen no puede ser vacío")
  private String imagenUrl;

  private boolean activa = true;
}
