package com.devsenior.llavemaestra.dto.response;

import com.devsenior.llavemaestra.enums.CategoriaHerramienta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HerramientaResponse {

  private Long id;
  private String nombre;
  private CategoriaHerramienta categoria;
  private String descripcion;
  private Double precioDia;
  private Double deposito;
  private Integer unidades;
  private String imagenUrl;
  private boolean activa = true;
}
