package com.fundappcion.config;

/**
 * Created by santi on 16/05/2017.
 */
public class RequestError {
    private String tipo;
    private String descripcion;

    public RequestError(String tipo, String descripcion) {
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "{ \n tipo: " + tipo + "\n descripcion: " + descripcion + "\n }";
    }
}
