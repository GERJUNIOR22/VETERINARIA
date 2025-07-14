package com.veterinaria.spring.veterinaria.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String dni;
    private String telefono;
    private String direccion;

    /* Relación uno‑a‑uno con Usuario */
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    /* ----------  CONSTRUCTORES  ---------- */
    public Cliente() { }

    public Cliente(String nombre, String dni, String telefono, String direccion, Usuario usuario) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.usuario = usuario;
    }

    /* ----------  GETTERS & SETTERS  ---------- */
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
