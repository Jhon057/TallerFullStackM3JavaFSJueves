package com.devsenior.llavemaestra.models;

import com.devsenior.llavemaestra.enums.CategoriaHerramienta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "herramientas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Herramienta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nombre;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private CategoriaHerramienta categoria;

  @Column(length = 500)
  private String descripcion;

  @Column(nullable = false)
  private Double precioDia;

  @Column(nullable = false)
  private Double deposito;

  @Column(nullable = false)
  private Integer unidades;

  @Column(length = 500)
  private String imagenUrl;

  @Column(nullable = false)
  private boolean activa = true;

}
