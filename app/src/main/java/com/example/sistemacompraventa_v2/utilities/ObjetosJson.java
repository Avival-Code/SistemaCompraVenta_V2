package com.example.sistemacompraventa_v2.utilities;

import com.example.sistemacompraventa_v2.entidades.Domicilio;
import com.example.sistemacompraventa_v2.entidades.EvaluacionUsuario;
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

    public JSONObject crearObjetoJson( EvaluacionUsuario evaluacion ) throws org.json.JSONException {
        JSONObject objeto = new JSONObject();
        objeto.put( "clave_usuario", evaluacion.getClaveUsuario() );
        objeto.put( "clave_evaluador_de_usuario", evaluacion.getClaveEvaluador() );
        objeto.put( "evaluacion", evaluacion.getEvaluacion() );
        objeto.put( "calificacion", evaluacion.getCalificacion() );
        return objeto;
    }

    public JSONObject crearObjetoJson( Domicilio domicilio ) throws org.json.JSONException {
        JSONObject objeto = new JSONObject();
        objeto.put( "discriminante_domicilio", domicilio.getDiscriminante() );
        objeto.put( "clave_usuario", domicilio.getClaveUsuario() );
        objeto.put( "calle", domicilio.getCalle() );
        objeto.put( "colonia", domicilio.getColonia() );
        objeto.put( "municipio", domicilio.getMunicipio() );
        objeto.put( "codigo_postal", domicilio.getCodigo() );
        objeto.put( "estado", domicilio.getEstado() );
        objeto.put( "numero_interno", domicilio.getNumerInterno() );
        objeto.put( "numero_externo", domicilio.getNumeroExterno() );
        objeto.put( "descripcion", domicilio.getDescripcion() );
        return objeto;
    }

    public JSONObject crearObjetoJson( String username, String password ) throws org.json.JSONException {
        JSONObject objeto = new JSONObject();
        objeto.put( "username", username );
        objeto.put( "password", password );
        return objeto;
    }

    public JSONObject crearObjetoJson( int claveUsuario, int clavePublicacion ) throws org.json.JSONException {
        JSONObject objeto = new JSONObject();
        objeto.put( "clave_usuario_usuario", claveUsuario );
        objeto.put( "clave_producto_producto", clavePublicacion );
        return objeto;
    }
}
