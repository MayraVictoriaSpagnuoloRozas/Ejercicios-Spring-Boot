package com.example.demo.Entidad;

import jakarta.persistence.*;

@Entity
@Table
public class Persona {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer ID;
    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;
    @Column(name="telefono", length = 100, nullable = false)
    private String telefono;

    public Persona(){

    }

    public Persona(int ID, String nombre, String telefono) {
        this.ID = ID;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
