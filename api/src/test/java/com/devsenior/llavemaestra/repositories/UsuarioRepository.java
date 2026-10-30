package com.devsenior.llavemaestra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.llavemaestra.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
