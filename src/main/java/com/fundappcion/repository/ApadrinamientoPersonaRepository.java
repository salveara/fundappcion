package com.fundappcion.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fundappcion.entity.ApadrinamientoPersona;

public interface ApadrinamientoPersonaRepository extends CrudRepository<ApadrinamientoPersona, String>{

    ApadrinamientoPersona save(ApadrinamientoPersona apadrinamiento);

    ApadrinamientoPersona findOne(String codigo);

    List<ApadrinamientoPersona> findByIdAhijadoContaining(String idAhijado);

    List<ApadrinamientoPersona> findByIdPadrinoContaining(String idPadrino);

    List<ApadrinamientoPersona> findAll();

    boolean exists(String codigo);

    void delete(ApadrinamientoPersona apadrinamiento);

}
