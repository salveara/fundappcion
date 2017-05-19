package com.fundappcion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fundappcion.entity.ApadrinamientoMascota;
import com.fundappcion.repository.ApadrinamientoMascotaRepository;

@Service
public class MascotaService {

    @Autowired
    ApadrinamientoMascotaRepository repository;
    
    public boolean stringNotNullOrNotEmpty(String field) {
        return field != null || "".equals(field);
    }
    
    public boolean checkNotNulleableFields(ApadrinamientoMascota apadrinaMascota) {
        return stringNotNullOrNotEmpty(apadrinaMascota.getCodigo())
                && stringNotNullOrNotEmpty(apadrinaMascota.getIdMascota())
                && stringNotNullOrNotEmpty(apadrinaMascota.getConexion_pet());
    }

    public ApadrinamientoMascota saveApadrinaMascota(ApadrinamientoMascota apadrinaMascota) {
        return repository.save(apadrinaMascota);
    }

    public ApadrinamientoMascota getApadrinaMascotaByCodigo(String codigo) {
        return repository.findOne(codigo);
    }

    public List<ApadrinamientoMascota> getApadrinaMascotaFromParams(String mascota, String conexion) {
        if (stringNotNullOrNotEmpty(mascota)) {
            return repository.findByIdMascotaContaining(mascota);
        } else {
            if (stringNotNullOrNotEmpty(conexion)) {
                return repository.findByConexion_petContaining(conexion);
            }
        }
    return repository.findAll();
    }

    public boolean apadrinaMascotaExist(String codigo) {
        return repository.exists(codigo);
    }

    public ApadrinamientoMascota deleteApadrinaMascota(String codigo) {
        ApadrinamientoMascota apadrinaMascota = repository.findOne(codigo);
        repository.delete(apadrinaMascota);
        return apadrinaMascota;
    }
}
