package com.fundappcion.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "APADRINAMIENTO_MASCOTAS")
public class ApadrinamientoMascota {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String codigo;
    @NotNull
    private String idMascota;
    @NotNull
    private String conexion_pet;
    
    public ApadrinamientoMascota(){
    }

    public ApadrinamientoMascota(String idMascota, String conexion_pet) {
        this.idMascota = idMascota;
        this.conexion_pet = conexion_pet;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    public String getConexion_pet() {
        return conexion_pet;
    }

    public void setConexion_pet(String conexion_pet) {
        this.conexion_pet = conexion_pet;
    }
    
}
