package com.veterinaria.spring.veterinaria.service.impl;

import com.veterinaria.spring.veterinaria.model.Albergue;
import com.veterinaria.spring.veterinaria.repository.AlbergueRepository;
import com.veterinaria.spring.veterinaria.service.AlbergueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbergueServiceImpl implements AlbergueService {

    private final AlbergueRepository albergueRepository;

    @Autowired
    public AlbergueServiceImpl(AlbergueRepository albergueRepository) {
        this.albergueRepository = albergueRepository;
    }

    @Override
    public Albergue guardarAlbergue(Albergue albergue) {
        return albergueRepository.save(albergue);
    }

    @Override
    public Optional<Albergue> obtenerAlberguePorId(Integer id) {
        return albergueRepository.findById(id);
    }

    @Override
    public List<Albergue> listarAlbergues() {
        return albergueRepository.findAll();
    }

    @Override
    public void eliminarAlbergue(Integer id) {
        albergueRepository.deleteById(id);
    }
}
