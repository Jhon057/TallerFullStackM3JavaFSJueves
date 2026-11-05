package com.devsenior.llavemaestra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.llavemaestra.models.Herramienta;

public interface HerramientaRepository extends JpaRepository<Herramienta, Long> {

  List<Herramienta> findByActivaTrue();

}
