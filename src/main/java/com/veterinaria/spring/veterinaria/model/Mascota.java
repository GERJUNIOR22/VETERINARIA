package com.veterinaria.spring.veterinaria.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mascotas")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String especie;
    private String raza;
    private Integer edad;
    private String estado;   // Disponible, Adoptado, etc.

    /* Relaciones */
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "albergue_id")
    private Albergue albergue;

    /* ----------  CONSTRUCTORES  ---------- */
    public Mascota() { }

    public Mascota(String nombre, String especie, String raza, Integer edad,
                   String estado, Cliente cliente, Albergue albergue) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.estado = estado;
        this.cliente = cliente;
        this.albergue = albergue;
    }

    /* ----------  GETTERS & SETTERS  ---------- */
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public Integer getEdad() { return edad; }
    public void setEdad(Integer edad) { this.edad = edad; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Albergue getAlbergue() { return albergue; }
    public void setAlbergue(Albergue albergue) { this.albergue = albergue; }
}
