package com.veterinaria.spring.veterinaria.service.impl;

import com.veterinaria.spring.veterinaria.model.Mascota;
import com.veterinaria.spring.veterinaria.repository.MascotaRepository;
import com.veterinaria.spring.veterinaria.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;

    @Autowired
    public MascotaServiceImpl(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    @Override
    public Mascota guardarMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public Optional<Mascota> obtenerMascotaPorId(Integer id) {
        return mascotaRepository.findById(id);
    }

    @Override
    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public void eliminarMascota(Integer id) {
        mascotaRepository.deleteById(id);
    }
}
