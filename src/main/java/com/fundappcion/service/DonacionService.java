package com.fundappcion.service;

import com.fundappcion.entity.Donacion;
import com.fundappcion.entity.Fundacion;
import com.fundappcion.repository.DonacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonacionService {

    @Autowired
    DonacionRepository repository;

    public boolean stringNotNullOrNotEmpty(String field) {
        return field != null || "".equals(field);
    }

    public Donacion saveDonacion(Donacion donacion) {
        return repository.save(donacion);
    }

    public List<Donacion> getDonations() {
        return repository.findAll();
    }

    public List<Donacion> getDonationsFromParams(String donante, String fundacion) {
        if (stringNotNullOrNotEmpty(donante)) {
            return repository.findByDonanteContaining(donante);
        } else {
            if (stringNotNullOrNotEmpty(fundacion)) {
                return repository.findByFundacionContaining(fundacion);
            }
        }
        return repository.findAll();
    }

    public Donacion getDonationByCode(String code) {
        return repository.findOne(code);
    }
}
