package com.veterinaria.spring.veterinaria.service;

import com.veterinaria.spring.veterinaria.model.Albergue;
import java.util.List;
import java.util.Optional;

public interface AlbergueService {
    Albergue guardarAlbergue(Albergue albergue);
    Optional<Albergue> obtenerAlberguePorId(Integer id);
    List<Albergue> listarAlbergues();
    void eliminarAlbergue(Integer id);
}
