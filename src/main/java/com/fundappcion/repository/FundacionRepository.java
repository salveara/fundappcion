package com.fundappcion.repository;

import com.fundappcion.entity.Fundacion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FundacionRepository extends CrudRepository<Fundacion, String> {

    Fundacion save(Fundacion fundacion);

    Fundacion findOne(String code);

    List<Fundacion> findAll();

    List<Fundacion> findByNombreContaining(String nombre);

    List<Fundacion> findByCiudadContaining(String ciudad);

    void delete(Fundacion fundacion);

    boolean exists(String nit);
}
