package com.veterinaria.spring.veterinaria.service;

import com.veterinaria.spring.veterinaria.model.Mascota;
import java.util.List;
import java.util.Optional;

public interface MascotaService {
    Mascota guardarMascota(Mascota mascota);
    Optional<Mascota> obtenerMascotaPorId(Integer id);
    List<Mascota> listarMascotas();
    void eliminarMascota(Integer id);
}
