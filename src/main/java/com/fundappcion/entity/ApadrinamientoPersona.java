package com.fundappcion.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "APADRINAMIENTO_PERSONAS")
public class ApadrinamientoPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String codigo;
    @NotNull
    private String idAhijado;
    @NotNull
    private String idPadrino;
    @NotNull
    private Date fechaInicio;
    @NotNull
    private Date fechaDonacion;
    @NotNull
    private String tipoAyuda;
    
    public ApadrinamientoPersona(){
    }

    public ApadrinamientoPersona(String idAhijado, String idPadrino, Date fechaInicio,
            Date fechaDonacion, String tipoAyuda) {
        this.idAhijado = idAhijado;
        this.idPadrino = idPadrino;
        this.fechaInicio = fechaInicio;
        this.fechaDonacion = fechaDonacion;
        this.tipoAyuda = tipoAyuda;
    }

    @ApiModelProperty(hidden = true)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @ApiModelProperty(example = "1233434546", required = true, position = 1)
    public String getIdAhijado() {
        return idAhijado;
    }

    public void setIdAhijado(String idAhijado) {
        this.idAhijado = idAhijado;
    }

    @ApiModelProperty(example = "67867654", required = true, position = 2)
    public String getIdPadrino() {
        return idPadrino;
    }

    public void setIdPadrino(String idPadrino) {
        this.idPadrino = idPadrino;
    }

    @ApiModelProperty(example = "04-05-2016", required = true, position = 3)
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @ApiModelProperty(example = "10-04-2017", required = true, position = 4)
    public Date getFechaDonacion() {
        return fechaDonacion;
    }

    public void setFechaDonacion(Date fechaDonacion) {
        this.fechaDonacion = fechaDonacion;
    }

    @ApiModelProperty(example = "Vestuario", required = true, position = 5)
    public String getTipoAyuda() {
        return tipoAyuda;
    }

    public void setTipoAyuda(String tipoAyuda) {
        this.tipoAyuda = tipoAyuda;
    }
    
}
