package com.devsenior.llavemaestra.config;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.devsenior.llavemaestra.enums.Categoria;
import com.devsenior.llavemaestra.enums.Rol;
import com.devsenior.llavemaestra.models.Herramienta;
import com.devsenior.llavemaestra.models.Usuario;
import com.devsenior.llavemaestra.repositories.HerramientaRepository;
import com.devsenior.llavemaestra.repositories.UsuarioRepository;

@Component
public class DataInitializer implements CommandLineRunner {

  private final UsuarioRepository usuarioRepository;
  private final HerramientaRepository herramientaRepository;
  private final PasswordEncoder passwordEncoder;

  public DataInitializer(UsuarioRepository usuarioRepository,
      HerramientaRepository herramientaRepository,
      PasswordEncoder passwordEncoder) {
    this.usuarioRepository = usuarioRepository;
    this.herramientaRepository = herramientaRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void run(String... args) throws Exception {
    // 1. Sembrar Usuarios (solo si la tabla está vacía)
    if (usuarioRepository.count() == 0) {
      String passwordDefault = passwordEncoder.encode("llave123");

      Usuario hernan = new Usuario();
      hernan.setNombre("Hernán Rojas");
      hernan.setEmail("admin@llavemaestra.co");
      hernan.setUsername("admin@llavemaestra.co");
      hernan.setPassword(passwordDefault);
      hernan.setRol(Rol.ADMIN);
      hernan.setActivo(true);
      hernan.setCreadoEn(LocalDateTime.now(ZoneId.systemDefault()));

      Usuario pedro = new Usuario();
      pedro.setNombre("Pedro Salazar");
      pedro.setEmail("pedro@correo.com");
      pedro.setUsername("pedro@correo.com");
      pedro.setPassword(passwordDefault);
      pedro.setRol(Rol.CLIENTE);
      pedro.setActivo(true);
      pedro.setCreadoEn(LocalDateTime.now(ZoneId.systemDefault()));

      Usuario diana = new Usuario();
      diana.setNombre("Diana Mejía");
      diana.setEmail("diana@correo.com");
      diana.setUsername("diana@correo.com");
      diana.setPassword(passwordDefault);
      diana.setRol(Rol.CLIENTE);
      diana.setActivo(true);
      diana.setCreadoEn(LocalDateTime.now(ZoneId.systemDefault()));

      Usuario jorge = new Usuario();
      jorge.setNombre("Jorge Pinzón");
      jorge.setEmail("jorge@correo.com");
      jorge.setUsername("jorge@correo.com");
      jorge.setPassword(passwordDefault);
      jorge.setRol(Rol.CLIENTE);
      jorge.setActivo(false); // Inactivo
      jorge.setCreadoEn(LocalDateTime.now(ZoneId.systemDefault()));

      usuarioRepository.saveAll(List.of(hernan, pedro, diana, jorge));
    }

    // 2. Sembrar Herramientas (solo si la tabla está vacía)
    if (herramientaRepository.count() == 0) {
      Herramienta h1 = new Herramienta(null, "Taladro percutor", Categoria.ELECTRICA,
          "Taladro potente para concreto y madera", BigDecimal.valueOf(25000.0), BigDecimal.valueOf(100000.0), 3,
          "https://loremflickr.com/300/200/drill", true);
      Herramienta h2 = new Herramienta(null, "Pulidora angular", Categoria.ELECTRICA,
          "Ideal para cortes y desbaste en metal", BigDecimal.valueOf(22000.0), BigDecimal.valueOf(80000.0), 2,
          "https://loremflickr.com/300/200/grinder", true);
      Herramienta h3 = new Herramienta(null, "Mezcladora de concreto", Categoria.CONSTRUCCION,
          "Mezcladora trompo para obra", BigDecimal.valueOf(60000.0), BigDecimal.valueOf(300000.0), 1,
          "https://loremflickr.com/300/200/mixer", true);
      Herramienta h4 = new Herramienta(null, "Andamio tubular", Categoria.CONSTRUCCION,
          "Estructura metálica para trabajos en altura", BigDecimal.valueOf(15000.0), BigDecimal.valueOf(120000.0), 4,
          "https://loremflickr.com/300/200/scaffolding", true);
      Herramienta h5 = new Herramienta(null, "Guadañadora", Categoria.JARDIN,
          "Para mantenimiento de prados y maleza", BigDecimal.valueOf(35000.0), BigDecimal.valueOf(150000.0), 2,
          "https://loremflickr.com/300/200/brushcutter", true);
      Herramienta h6 = new Herramienta(null, "Nivel láser", Categoria.MEDICION,
          "Nivelación láser de alta precisión", BigDecimal.valueOf(30000.0), BigDecimal.valueOf(200000.0), 1,
          "https://loremflickr.com/300/200/laser", false); // Retirada/inactiva

      herramientaRepository.saveAll(List.of(h1, h2, h3, h4, h5, h6));
    }
  }
}
