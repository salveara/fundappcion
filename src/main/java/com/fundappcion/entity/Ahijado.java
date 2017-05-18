package com.fundappcion.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "AHIJADO")
public class Ahijado {

    @Id
    private String id;
    @NotNull
    private String tipoId;
    @NotNull
    private String nombre;
    @NotNull
    private Date fechaNacimiento;
    @NotNull
    private String nacionalidad;
    @NotNull
    private String ciudadResidencia;
    @NotNull
    private String nitFundacion;
    private String direccionFundacion;
    private String telefonoContacto;
    private String situacion;
    
    public Ahijado(){
        
    }
    
    public Ahijado(String id, String tipoId, String nombre, Date fechaNacimiento, String nacionalidad,
            String ciudadResidencia, String nitFundacion, String direccionFundacion, String telefonoContacto,
            String situacion) {
        this.id = id;
        this.tipoId = tipoId;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.ciudadResidencia = ciudadResidencia;
        this.nitFundacion = nitFundacion;
        this.direccionFundacion = direccionFundacion;
        this.telefonoContacto = telefonoContacto;
        this.situacion = situacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public String getNitFundacion() {
        return nitFundacion;
    }

    public void setNitFundacion(String nitFundacion) {
        this.nitFundacion = nitFundacion;
    }

    public String getDireccionFundacion() {
        return direccionFundacion;
    }

    public void setDireccionFundacion(String direccionFundacion) {
        this.direccionFundacion = direccionFundacion;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }
    
    
}
