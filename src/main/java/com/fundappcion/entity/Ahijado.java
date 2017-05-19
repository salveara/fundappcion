package com.fundappcion.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "AHIJADO")
@ApiModel
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

    @ApiModelProperty(example = "1233434546")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @ApiModelProperty(example = "Tarjeta de identidad", required = true, position = 1)
    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    @ApiModelProperty(example = "Robbie Reyes", required = true, position = 2)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @ApiModelProperty(example = "19-05-2004", required = true, position = 3)
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    @ApiModelProperty(example = "Colombiana", required = true, position = 4)
    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    @ApiModelProperty(example = "Medellín", required = true, position = 5)
    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }
    
    @ApiModelProperty(example = "654123165", required = true, position = 6)
    public String getNitFundacion() {
        return nitFundacion;
    }

    public void setNitFundacion(String nitFundacion) {
        this.nitFundacion = nitFundacion;
    }
    
    @ApiModelProperty(example = "Crr 56 sur # 33b-56", position = 7)
    public String getDireccionFundacion() {
        return direccionFundacion;
    }

    public void setDireccionFundacion(String direccionFundacion) {
        this.direccionFundacion = direccionFundacion;
    }
    
    @ApiModelProperty(example = "3465789", position = 8)
    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    @ApiModelProperty(example = "Huerfano", position = 9)
    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }
    
    
}
