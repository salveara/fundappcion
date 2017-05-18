package com.fundappcion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundappcion.entity.Ahijado;
import com.fundappcion.repository.AhijadoRepository;

@Service
public class AhijadoService {

    @Autowired
    AhijadoRepository repository;
    
    public boolean stringNotNullOrNotEmpty(String field) {
        return field != null || "".equals(field);
    }
    
    public Ahijado saveAhijado(Ahijado ahijado){
        return repository.save(ahijado);
    }
    
    public Ahijado getAhijadoById(String id) {
        return repository.findOne(id);
    }
    
    public List<Ahijado> getAhijadosFromParams(String ciudad, String fundacion) {
        if (stringNotNullOrNotEmpty(ciudad)) {
            return repository.findByCiudadResidenciaContaining(ciudad);
        } else {
            if (stringNotNullOrNotEmpty(fundacion)) {
                return repository.findByNitFundacionContaining(fundacion);
            }
        }
        return repository.findAll();
    }

    public boolean checkNotNulleableFields(Ahijado ahijado) {
        return stringNotNullOrNotEmpty(ahijado.getNombre())
                && stringNotNullOrNotEmpty(ahijado.getCiudadResidencia())
                && stringNotNullOrNotEmpty(ahijado.getDireccionFundacion())
                && stringNotNullOrNotEmpty(ahijado.getTelefonoContacto())
                && stringNotNullOrNotEmpty(ahijado.getSituacion());
    }
    
    public boolean ahijadoExist(String id) {
        return repository.exists(id);
    }
}
