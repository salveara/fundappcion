package com.fundappcion.repository;

import com.fundappcion.entity.Donacion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DonacionRepository extends CrudRepository<Donacion, String> {

    Donacion save(Donacion donacion);

    Donacion findOne(String codigo);

    List<Donacion> findAll();

    List<Donacion> findByDonanteContaining(String donante);

    List<Donacion> findByFundacionContaining(String fundacion);

    void delete(Donacion donacion);

    boolean exists(String codigo);
}
