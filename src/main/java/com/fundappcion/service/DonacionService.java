package com.fundappcion.service;

import com.fundappcion.entity.Donacion;
import com.fundappcion.repository.DonacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonacionService {

    @Autowired
    DonacionRepository repository;

    public Donacion saveDonacion(Donacion donacion) {
        return repository.save(donacion);
    }

    public List<Donacion> getDonations() {
        return repository.findAll();
    }
}
