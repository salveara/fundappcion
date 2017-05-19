package com.fundappcion.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fundappcion.entity.ApadrinamientoMascota;

public interface ApadrinamientoMascotaRepository extends CrudRepository<ApadrinamientoMascota, String>{

    ApadrinamientoMascota save(ApadrinamientoMascota apadrinaMascota);

    ApadrinamientoMascota findOne(String codigo);

    List<ApadrinamientoMascota> findByIdMascotaContaining(String idmascota);

    List<ApadrinamientoMascota> findByConexion_petContaining(String conexion_pet);

    List<ApadrinamientoMascota> findAll();

    boolean exists(String codigo);

    void delete(ApadrinamientoMascota apadrinaMascota);

}
