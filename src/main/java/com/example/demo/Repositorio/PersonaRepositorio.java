package com.example.demo.Repositorio;

import com.example.demo.Entidad.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositorio extends JpaRepository <Persona, Integer> {

}
