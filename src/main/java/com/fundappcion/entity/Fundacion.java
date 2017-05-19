package com.fundappcion.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "FUDACION")
@ApiModel
public class Fundacion {

    @Id
    private String nit;
    @NotNull
    private String nombre;
    @NotNull
    private String descripcion;
    @NotNull
    private String correo;
    private String pagina;
    private String ciudad;
    private String direccion;
    private String telefono;

    public Fundacion() {
    }

    public Fundacion(String nit, String nombre, String descripcion, String correo, String pagina, String ciudad, String direccion, String telefono) {
        this.nit = nit;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.correo = correo;
        this.pagina = pagina;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    @ApiModelProperty(example = "654123165")
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @ApiModelProperty(example = "Fundación orca", required = true, position = 1)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @ApiModelProperty(example = "Fundación que protege los derechos de los animales", position = 2)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @ApiModelProperty(example = "fundacionorca@gmail.com", required = true, position = 3)
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @ApiModelProperty(example = "www.fundacionorca.com.co", position = 4)
    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    @ApiModelProperty(example = "Bogota", position = 5)
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @ApiModelProperty(example = "Crr 56 sur # 33b-56", position = 6)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @ApiModelProperty(example = "5699854", position = 7)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
