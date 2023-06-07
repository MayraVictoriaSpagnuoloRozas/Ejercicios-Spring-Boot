package com.example.demo.Servicio;

import com.example.demo.Entidad.Persona;
import com.example.demo.Repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class ImpPersonaServicio implements PersonaServicio{
    @Autowired
    private PersonaRepositorio personaRepositorio;

    @Override
    public List<Persona> ListarTodasLasPersonas() {
        return personaRepositorio.findAll();
    }

    @Override
    public Persona GuardarPersonas(Persona persona) {
        return personaRepositorio.save(persona);
    }

    @Override
    public Persona Agregar(Persona persona) {
        personaRepositorio.save(persona);
        return persona;
    }

    @Override
    public Persona ObtenerPorID(Integer ID) {

        return personaRepositorio.findById(ID).get();
    }

    @Override
    public Persona ActualizarPersona(Persona persona) {

        return personaRepositorio.save(persona);
    }

    @Override
    public void EliminarPersona(Integer ID) {
        personaRepositorio.deleteById(ID);

    }
}
