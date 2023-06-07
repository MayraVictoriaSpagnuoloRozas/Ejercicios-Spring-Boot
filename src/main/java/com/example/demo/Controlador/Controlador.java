package com.example.demo.Controlador;

import com.example.demo.Entidad.Persona;
import com.example.demo.Servicio.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class Controlador {
    @Autowired
    private PersonaServicio servicio;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/listar")
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
    public String Guardar(@ModelAttribute("persona") Persona persona){
        servicio.GuardarPersonas(persona);
        return "redirect:/listar";
    }

    @GetMapping("/eliminar/{ID}")
    public String EliminarPersona ( @PathVariable Integer ID){
        servicio.EliminarPersona(ID);
        return "redirect:/listar";
    }
    @GetMapping("/editar/{ID}")
    public String MostrarFormularioDeEditar(@PathVariable Integer ID , Model model){
        model.addAttribute ("persona" ,servicio.ObtenerPorID(ID));
        return "editar_persona";
    }

    public String ActualizarPersona (@PathVariable Integer ID, @ModelAttribute("persona") Persona persona, Model model){
        Persona personaExistente= servicio.ObtenerPorID(ID);
        personaExistente.setID(ID);
        personaExistente.setNombre(persona.getNombre());
        personaExistente.setTelefono(persona.getTelefono());
        servicio.ActualizarPersona(personaExistente);
        return "redirect:/listar";
    }
}

