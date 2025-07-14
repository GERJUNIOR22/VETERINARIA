package com.veterinaria.spring.veterinaria.service;

import com.veterinaria.spring.veterinaria.model.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteService {
    Cliente guardarCliente(Cliente cliente);
    Optional<Cliente> obtenerClientePorId(Integer id);
    List<Cliente> listarClientes();
    void eliminarCliente(Integer id);
}
