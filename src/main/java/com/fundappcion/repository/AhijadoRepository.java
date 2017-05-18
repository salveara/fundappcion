package com.fundappcion.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fundappcion.entity.Ahijado;

public interface AhijadoRepository extends CrudRepository<Ahijado, String>{
    
    Ahijado save(Ahijado ahijado);
    
    Ahijado findOne(String id);

    List<Ahijado> findByCiudadResidenciaContaining(String ciudadResidencia);

    List<Ahijado> findByNitFundacionContaining(String nitFundacion);
    
    List<Ahijado> findAll();
 }
