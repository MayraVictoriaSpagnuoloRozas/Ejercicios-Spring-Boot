package com.example.demo.Servicio;

import com.example.demo.Entidad.Persona;

import java.util.List;

public interface PersonaServicio {

    public List<Persona> ListarTodasLasPersonas();
    public Persona GuardarPersonas (Persona persona);
    public Persona Agregar (Persona persona);
    public Persona ObtenerPorID (Integer ID);
    public Persona ActualizarPersona(Persona persona);
    public void EliminarPersona (Integer ID);
}
