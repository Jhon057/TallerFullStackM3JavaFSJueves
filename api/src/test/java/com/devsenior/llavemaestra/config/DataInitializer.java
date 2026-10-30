package com.devsenior.llavemaestra.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.devsenior.llavemaestra.enums.CategoriaHerramienta;
import com.devsenior.llavemaestra.enums.Rol;
import com.devsenior.llavemaestra.models.Herramienta;
import com.devsenior.llavemaestra.models.Usuario;
import com.devsenior.llavemaestra.repositories.HerramientaRepository;
import com.devsenior.llavemaestra.repositories.UsuarioRepository;

@Configuration
public class DataInitializer {

  @Bean
  public CommandLineRunner initData(UsuarioRepository usuarioRepository,
      HerramientaRepository herramientaRepository,
      PasswordEncoder passwordEncoder) {
    return args -> {
      // 1. Sembrar usuarios si la tabla está vacía
      if (usuarioRepository.count() == 0) {
        String passwordDefault = passwordEncoder.encode("llave123");

        Usuario hernan = new Usuario(null, "Hernán Rojas", "admin@llavemaestra.co", passwordDefault, Rol.ADMIN, true,
            null);
        Usuario pedro = new Usuario(null, "Pedro Salazar", "pedro@correo.com", passwordDefault, Rol.CLIENTE, true,
            null);
        Usuario diana = new Usuario(null, "Diana Mejía", "diana@correo.com", passwordDefault, Rol.CLIENTE, true, null);
        Usuario jorge = new Usuario(null, "Jorge Pinzón", "jorge@correo.com", passwordDefault, Rol.CLIENTE, false,
            null); // Bloqueado

        usuarioRepository.save(hernan);
        usuarioRepository.save(pedro);
        usuarioRepository.save(diana);
        usuarioRepository.save(jorge);
      }

      // 2. Sembrar herramientas si la tabla está vacía
      if (herramientaRepository.count() == 0) {
        Herramienta h1 = new Herramienta(null, "Taladro percutor", CategoriaHerramienta.ELECTRICA,
            "Taladro percutor profesional para trabajos pesados", 25000.0, 100000.0, 3,
            "https://loremflickr.com/320/240/drill", true);
        Herramienta h2 = new Herramienta(null, "Pulidora angular", CategoriaHerramienta.ELECTRICA,
            "Pulidora angular de 4-1/2 pulgadas", 22000.0, 80000.0, 2, "https://loremflickr.com/320/240/grinder", true);
        Herramienta h3 = new Herramienta(null, "Mezcladora de concreto", CategoriaHerramienta.CONSTRUCCION,
            "Mezcladora de concreto tipo trompo 1 saco", 60000.0, 300000.0, 1, "https://loremflickr.com/320/240/mixer",
            true);
        Herramienta h4 = new Herramienta(null, "Andamio tubular", CategoriaHerramienta.CONSTRUCCION,
            "Módulo de andamio tubular metálico", 15000.0, 120000.0, 4, "https://loremflickr.com/320/240/scaffolding",
            true);
        Herramienta h5 = new Herramienta(null, "Guadañadora", CategoriaHerramienta.JARDIN,
            "Guadañadora a gasolina de eje recto", 35000.0, 150000.0, 2, "https://loremflickr.com/320/240/brushcutter",
            true);
        Herramienta h6 = new Herramienta(null, "Nivel láser", CategoriaHerramienta.MEDICION,
            "Nivel láser rotativo con trípode", 30000.0, 200000.0, 1, "https://loremflickr.com/320/240/laser", false); // Retirada/Inactiva

        herramientaRepository.save(h1);
        herramientaRepository.save(h2);
        herramientaRepository.save(h3);
        herramientaRepository.save(h4);
        herramientaRepository.save(h5);
        herramientaRepository.save(h6);
      }
    };
  }
}
