package com.fundappcion.entity.dto;

public class FundacionDto {

    private String nombre;
    private String descripcion;
    private String correo;
    private String pagina;
    private String ciudad;
    private String direccion;
    private String telefono;

    public FundacionDto(String nombre, String descripcion, String correo, String pagina, String ciudad, String direccion, String telefono) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.correo = correo;
        this.pagina = pagina;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
