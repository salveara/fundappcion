package com.fundappcion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundappcion.entity.ApadrinamientoPersona;
import com.fundappcion.entity.Fundacion;
import com.fundappcion.repository.ApadrinamientoPersonaRepository;

@Service
public class ApadrinamientoService {

    @Autowired
    ApadrinamientoPersonaRepository repository;
    
    public boolean stringNotNullOrNotEmpty(String field) {
        return field != null || "".equals(field);
    }
    
    public boolean checkNotNulleableFields(ApadrinamientoPersona apadrinamiento) {
        return stringNotNullOrNotEmpty(apadrinamiento.getCodigo())
                && stringNotNullOrNotEmpty(apadrinamiento.getIdAhijado())
                && stringNotNullOrNotEmpty(apadrinamiento.getIdPadrino())
                && stringNotNullOrNotEmpty(apadrinamiento.getTipoAyuda())
                && stringNotNullOrNotEmpty(apadrinamiento.getFechaDonacion().toString())
                && stringNotNullOrNotEmpty(apadrinamiento.getFechaInicio().toString());
    }

    public ApadrinamientoPersona saveApadrinamiento(ApadrinamientoPersona apadrinamiento) {
        return repository.save(apadrinamiento);
    }

    public ApadrinamientoPersona getApadrinamientoByCodigo(String codigo) {
        return repository.findOne(codigo);
    }

    public List<ApadrinamientoPersona> getApadrinamientosFromParams(String ahijado, String padrino) {
        if (stringNotNullOrNotEmpty(ahijado)) {
            return repository.findByIdAhijadoContaining(ahijado);
        } else {
            if (stringNotNullOrNotEmpty(padrino)) {
                return repository.findByIdPadrinoContaining(padrino);
            }
        }
    return repository.findAll();
    }

    public boolean apadrinamientoExist(String codigo) {
        return repository.exists(codigo);
    }

    public ApadrinamientoPersona deleteApadrinamiento(String codigo) {
        ApadrinamientoPersona apadrinamiento = repository.findOne(codigo);
        repository.delete(apadrinamiento);
        return apadrinamiento;
    }
}
