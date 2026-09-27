package com.yclsolutions.app;

public class Cliente {

    private int idCliente;
    private String codigo;
    private String documento;
    private String nombre;
    private String telefono;
    private String correo;
    private String ciudad;
    private String estado;

    public Cliente(int idCliente, String codigo, String documento, String nombre,
                   String telefono, String correo, String ciudad, String estado) {

        this.idCliente = idCliente;
        this.codigo = codigo;
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "ID: " + idCliente +
               " | Código: " + codigo +
               " | Documento: " + documento +
               " | Nombre: " + nombre +
               " | Teléfono: " + telefono +
               " | Correo: " + correo +
               " | Ciudad: " + ciudad +
               " | Estado: " + estado;
    }
}