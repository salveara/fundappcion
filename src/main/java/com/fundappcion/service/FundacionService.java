package com.fundappcion.service;

import com.fundappcion.entity.Fundacion;
import com.fundappcion.repository.FundacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FundacionService {

    @Autowired
    FundacionRepository repository;

    public Fundacion saveFoundation(Fundacion fundacion) {
        return repository.save(fundacion);
    }

    public Fundacion getFoundationsFromNit(String nit) {
        return repository.findOne(nit);
    }

    public boolean foundationExist(String nit) {
        return repository.exists(nit);
    }

    public List<Fundacion> getFoundationsFromParams(String name, String city) {
            if (stringNotNullOrNotEmpty(name)) {
                return repository.findByNombreContaining(name);
            } else {
                if (stringNotNullOrNotEmpty(city)) {
                    return repository.findByCiudadContaining(city);
                }
            }
        return repository.findAll();
    }

    public Fundacion deleteFoundation(String code) {
        Fundacion fundacion = repository.findOne(code);
        repository.delete(fundacion);
        return fundacion;
    }

    public boolean checkNotNulleableFields(Fundacion fundacion) {
        return stringNotNullOrNotEmpty(fundacion.getNit())
                && stringNotNullOrNotEmpty(fundacion.getNombre())
                && stringNotNullOrNotEmpty(fundacion.getCorreo());
    }

    public boolean stringNotNullOrNotEmpty(String field) {
        return field != null || "".equals(field);
    }


}
