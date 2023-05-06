package com.example.demo.Controlador;

import ch.qos.logback.core.model.Model;
import com.example.demo.Entidad.Persona;
import com.example.demo.Servicio.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Controlador {
    @Autowired
    private PersonaServicio servicio;
    @GetMapping ("/Lista")
    public String listar (Model model){
        List<Persona> personas= servicio.ListarTodasLasPersonas();
        model.addAttribute("personas", personas);
        return "index";
    }
    @GetMapping("/new")
    public String Agregar(Model model){
        Persona persona = new Persona();
        model.addAttribute("persona",persona);
        return "crear_persona";
    }


    @PostMapping("/save")
    public String Guardar(@ModelAttribute("estudiante") Persona persona){
        servicio.GuardarPersonas(persona);
        return "redirect:/listar";
    }
}
