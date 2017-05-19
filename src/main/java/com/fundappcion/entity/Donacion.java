package com.fundappcion.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "DONACION")
@ApiModel
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

    @ApiModelProperty(hidden = true)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDonante() {
        return donante;
    }

    public void setDonante(String donante) {
        this.donante = donante;
    }

    public String getFundacion() {
        return fundacion;
    }

    public void setFundacion(String fundacion) {
        this.fundacion = fundacion;
    }

    public Date getFechaDonacion() {
        return fechaDonacion;
    }

    public void setFechaDonacion(Date fechaDonacion) {
        this.fechaDonacion = fechaDonacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @ApiModelProperty(example = "No validado")
    public String getValidacion() {
        return validacion;
    }

    public void setValidacion(String validacion) {
        this.validacion = validacion;
    }
}
