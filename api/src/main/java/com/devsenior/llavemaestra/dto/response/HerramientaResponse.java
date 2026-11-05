package com.devsenior.llavemaestra.dto.response;

import java.math.BigDecimal;

import com.devsenior.llavemaestra.enums.Categoria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HerramientaResponse {

  private Long id;
  private String nombre;
  private Categoria categoria;
  private String descripcion;
  private BigDecimal precioDia;
  private BigDecimal deposito;
  private Integer unidades;
  private String imagenUrl;
  private boolean activa;
}
