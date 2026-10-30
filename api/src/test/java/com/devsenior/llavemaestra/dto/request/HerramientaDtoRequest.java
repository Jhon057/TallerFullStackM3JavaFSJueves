package com.devsenior.llavemaestra.dto.request;

import com.devsenior.llavemaestra.enums.CategoriaHerramienta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HerramientaDtoRequest {

  @NotBlank(message = "El valor de nombre no puede estar vacío")
  private String nombre;

  @NotNull(message = "El valor de categoría no puede estar vacío")
  private CategoriaHerramienta categoria;

  @NotBlank(message = "El valor de descripción no puede estar vacío")
  private String descripcion;

  @NotNull(message = "El valor de precio no puede estar vacío")
  private Double precioDia;

  @NotNull(message = "El valor de deposito no puede estar vacío")
  private Double deposito;

  @NotNull(message = "El valor de unidades no puede estar vacío")
  private Integer unidades;

  @NotBlank(message = "El valor de imagen no puede estar vacío")
  private String imagenUrl;

}
