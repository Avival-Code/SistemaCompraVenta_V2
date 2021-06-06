package com.example.sistemacompraventa_v2.entidades;

import com.example.sistemacompraventa_v2.enumeraciones.TipoUsuario;

public class Usuario {
    private int claveUsuario;
    private String nombres;
    private String apellidos;
    private String correoElectronico;
    private String nombreUsuario;
    private String contrasena;
    private TipoUsuario tipoUsuario;
    private String telefono;
    private float calificacion;

    public Usuario() {
        nombres = "";
        apellidos = "";
        correoElectronico = "";
        telefono = "";
        nombreUsuario = "";
        contrasena = "";
        calificacion = 0.0f;
        tipoUsuario = null;
    }

    public Usuario( Usuario original ) {
        nombres = original.nombres;
        apellidos = original.apellidos;
        correoElectronico = original.correoElectronico;
        telefono = original.telefono;
        nombreUsuario = original.nombreUsuario;
        contrasena = original.contrasena;
        calificacion = original.calificacion;
        tipoUsuario = original.tipoUsuario;
    }

    public Usuario( String nombresIn, String apellidosIn, String correoIn, String telefonoIn,
                    String usuarioIn, String contrasenaIn, float calificacionIn, TipoUsuario tipoIn ) {
        nombres = nombresIn;
        apellidos = apellidosIn;
        correoElectronico = correoIn;
        telefono = telefonoIn;
        nombreUsuario = usuarioIn;
        contrasena = contrasenaIn;
        calificacion = calificacionIn;
        tipoUsuario = tipoIn;
    }

    public int getClaveUsuario() { return claveUsuario; }

    public String getNombres() { return nombres; }

    public String getApellidos() { return apellidos; }

    public String getCorreoElectronico() { return correoElectronico; }

    public String getTelefono() { return telefono; }

    public String getUsuario() { return nombreUsuario; }

    public String getContrasena() { return contrasena; }

    public float getCalificacion() { return calificacion; }

    public TipoUsuario getTipoUsuario() { return tipoUsuario; }

    public void setClaveUsuario( int claveUsuarioIn ) { claveUsuario = claveUsuarioIn; }

    public void setNombres( String nombresIn ) { nombres = nombresIn; }

    public void setApellidos( String apellidosIn ) { apellidos = apellidosIn; }

    public void setCorreoElectronico( String correoIn ) { correoElectronico = correoIn; }

    public void setTelefono( String telefonoIn ) { telefono = telefonoIn; }

    public void setUsuario( String usuarioIn ) { nombreUsuario = usuarioIn; }

    public void setContrasena( String contrasenaIn ) { contrasena = contrasenaIn; }

    public void setCalificacion( float calificacionIn ) { calificacion = calificacionIn; }

    public void setTipoUsuario( TipoUsuario tipoIn ) { tipoUsuario = tipoIn; }
}
