package com.fundappcion.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIdAhijado() {
        return idAhijado;
    }

    public void setIdAhijado(String idAhijado) {
        this.idAhijado = idAhijado;
    }

    public String getIdPadrino() {
        return idPadrino;
    }

    public void setIdPadrino(String idPadrino) {
        this.idPadrino = idPadrino;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaDonacion() {
        return fechaDonacion;
    }

    public void setFechaDonacion(Date fechaDonacion) {
        this.fechaDonacion = fechaDonacion;
    }

    public String getTipoAyuda() {
        return tipoAyuda;
    }

    public void setTipoAyuda(String tipoAyuda) {
        this.tipoAyuda = tipoAyuda;
    }
    
}
