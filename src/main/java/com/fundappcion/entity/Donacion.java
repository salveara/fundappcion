package com.fundappcion.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "DONACION")
public class Donacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String codigo;
    @NotNull
    private String donante;
    @NotNull
    private String fundacion;
    @NotNull
    private Date fechaDonacion;
    @NotNull
    private String descripcion;
    @NotNull
    private int cantidad;
    private String imagen;
    private String validacion;

    public Donacion() {
    }

    public Donacion(String donante, String fundacion, Date fechaDonacion, String descripcion, int cantidad, String imagen, String validacion) {
        this.donante = donante;
        this.fundacion = fundacion;
        this.fechaDonacion = fechaDonacion;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.imagen = imagen;
        this.validacion = validacion;
    }
}
