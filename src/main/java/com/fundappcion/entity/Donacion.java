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

    @ApiModelProperty(example = "1235456554", required = true, position = 1)
    public String getDonante() {
        return donante;
    }

    public void setDonante(String donante) {
        this.donante = donante;
    }

    @ApiModelProperty(example = "654123165", required = true, position = 2)
    public String getFundacion() {
        return fundacion;
    }

    public void setFundacion(String fundacion) {
        this.fundacion = fundacion;
    }

    @ApiModelProperty(example = "14-05-2017", required = true, position = 3)
    public Date getFechaDonacion() {
        return fechaDonacion;
    }

    public void setFechaDonacion(Date fechaDonacion) {
        this.fechaDonacion = fechaDonacion;
    }

    @ApiModelProperty(example = "Televisor", required = true, position = 4)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @ApiModelProperty(example = "3", required = true, position = 5)
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @ApiModelProperty(example = "imagen.jpg", position = 6)
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @ApiModelProperty(example = "No validado", position = 7)
    public String getValidacion() {
        return validacion;
    }

    public void setValidacion(String validacion) {
        this.validacion = validacion;
    }
}
