package com.example.sistemacompraventa_v2.entidades;

import com.example.sistemacompraventa_v2.enumeraciones.TipoUsuario;

public class Usuario {
    private String nombres;
    private String apellidos;
    private String correoElectronico;
    private String telefono;
    private String usuario;
    private String contrasena;
    private float calificacion;
    private TipoUsuario tipoUsuario;

    public Usuario() {
        nombres = "";
        apellidos = "";
        correoElectronico = "";
        telefono = "";
        usuario = "";
        contrasena = "";
        calificacion = 0.0f;
        tipoUsuario = null;
    }

    public Usuario( Usuario original ) {
        nombres = original.nombres;
        apellidos = original.apellidos;
        correoElectronico = original.correoElectronico;
        telefono = original.telefono;
        usuario = original.usuario;
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
        usuario = usuarioIn;
        contrasena = contrasenaIn;
        calificacion = calificacionIn;
        tipoUsuario = tipoIn;
    }

    public String getNombres() { return nombres; }

    public String getApellidos() { return apellidos; }

    public String getCorreoElectronico() { return correoElectronico; }

    public String getTelefono() { return telefono; }

    public String getUsuario() { return usuario; }

    public String getContrasena() { return contrasena; }

    public float getCalificacion() { return calificacion; }

    public TipoUsuario getTipoUsuario() { return tipoUsuario; }

    public void setNombres( String nombresIn ) { nombres = nombresIn; }

    public void setApellidos( String apellidosIn ) { apellidos = apellidosIn; }

    public void setCorreoElectronico( String correoIn ) { correoElectronico = correoIn; }

    public void setTelefono( String telefonoIn ) { telefono = telefonoIn; }

    public void setUsuario( String usuarioIn ) { usuario = usuarioIn; }

    public void setContrasena( String contrasenaIn ) { contrasena = contrasenaIn; }

    public void setCalificacion( float calificacionIn ) { calificacion = calificacionIn; }

    public void setTipoUsuario( TipoUsuario tipoIn ) { tipoUsuario = tipoIn; }
}
