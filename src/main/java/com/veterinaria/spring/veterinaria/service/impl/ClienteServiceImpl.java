package com.veterinaria.spring.veterinaria.service.impl;

import com.veterinaria.spring.veterinaria.model.Cliente;
import com.veterinaria.spring.veterinaria.repository.ClienteRepository;
import com.veterinaria.spring.veterinaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> obtenerClientePorId(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public void eliminarCliente(Integer id) {
        clienteRepository.deleteById(id);
    }
}
