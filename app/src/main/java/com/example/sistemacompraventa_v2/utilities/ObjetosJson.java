package com.example.sistemacompraventa_v2.utilities;

import com.example.sistemacompraventa_v2.entidades.Usuario;

import org.json.JSONObject;

public class ObjetosJson {
    public JSONObject crearObjectoJson( Usuario usuario ) throws org.json.JSONException {
        JSONObject objeto = new JSONObject();
        objeto.put( "nombres", usuario.getNombres() );
        objeto.put( "apellidos", usuario.getApellidos() );
        objeto.put( "nombre_usuario", usuario.getUsuario() );
        objeto.put( "contrasena", usuario.getContrasena() );
        objeto.put( "correo_electronico", usuario.getCorreoElectronico() );
        objeto.put( "telefono", usuario.getTelefono() );
        objeto.put( "tipo_usuario", usuario.getTipoUsuario().ordinal() );
        objeto.put( "calificacion", usuario.getCalificacion() );
        return objeto;
    }
}
