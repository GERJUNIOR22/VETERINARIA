package com.veterinaria.spring.veterinaria.model;

import jakarta.persistence.*;

@Entity
@Table(name = "albergues")
public class Albergue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String direccion;
    private String telefono;

    /* ----------  CONSTRUCTORES  ---------- */
    public Albergue() { }

    public Albergue(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /* ----------  GETTERS & SETTERS  ---------- */
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
