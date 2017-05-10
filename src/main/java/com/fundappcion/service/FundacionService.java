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

    public List<Fundacion> getFoundationsFromParams(String code, String name, String city) {
        if (stringNotNullOrEmpty(code)) {
            ArrayList<Fundacion> fundaciones = new ArrayList<Fundacion>();
            fundaciones.add(repository.findOne(code));
            return fundaciones;
        } else {
            if (stringNotNullOrEmpty(name)) {
                return repository.findByNombreContaining(name);
            } else {
                if (stringNotNullOrEmpty(city)) {
                    return repository.findByCiudadContaining(city);
                }
            }
        }
        return repository.findAll();
    }

    public Fundacion deleteFoundation(String code) {
        Fundacion fundacion = repository.findOne(code);
        repository.delete(fundacion);
        return fundacion;
    }

    public boolean stringNotNullOrEmpty(String field) {
        return field != null || "".equals(field);
    }

}
