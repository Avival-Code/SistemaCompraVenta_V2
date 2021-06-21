package com.example.sistemacompraventa_v2.utilities;

import com.example.sistemacompraventa_v2.entidades.Domicilio;
import com.example.sistemacompraventa_v2.entidades.EvaluacionUsuario;
import com.example.sistemacompraventa_v2.entidades.Publicacion;
import com.example.sistemacompraventa_v2.entidades.Transaccion;
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

    public JSONObject crearObjetoJson( EvaluacionUsuario evaluacion, int claveTransaccion ) throws org.json.JSONException {
        JSONObject objeto = new JSONObject();
        objeto.put( "clave_usuario", evaluacion.getClaveUsuario() );
        objeto.put( "clave_evaluador_de_usuario", evaluacion.getClaveEvaluador() );
        objeto.put( "evaluacion", evaluacion.getEvaluacion() );
        objeto.put( "calificacion", evaluacion.getCalificacion() );
        objeto.put( "clave_transaccion", claveTransaccion );
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

    public JSONObject crearObjetoJson( Publicacion publicacion ) throws org.json.JSONException {
        JSONObject objeto = new JSONObject();
        objeto.put( "clave_publicacion", publicacion.getClave_publicacion() );
        objeto.put( "nombre", publicacion.getNombre() );
        objeto.put( "descripcion", publicacion.getDescripcion() );
        objeto.put( "categoria", publicacion.getCategoria().ordinal() );
        objeto.put( "precio", publicacion.getPrecio() );
        objeto.put( "cantidad_disponible", publicacion.getCantidad_disponible() );
        objeto.put( "calificacion_general", publicacion.getCalificacion_general() );
        objeto.put( "unidad_medida", publicacion.getUnidad_medida() );
        objeto.put( "numero_ventas", publicacion.getNumero_ventas() );
        objeto.put( "imagen", publicacion.getImagen() );
        return objeto;
    }

    public JSONObject crearObjetoJson( Transaccion transaccion ) throws org.json.JSONException {
        JSONObject objeto = new JSONObject();
        objeto.put( "clave_transaccion", transaccion.getClaveTransaccion() );
        objeto.put( "clave_vendedor", transaccion.getClaveVendedor() );
        objeto.put( "direccion_comprador", transaccion.getDireccionComprador() );
        objeto.put( "fecha_venta", transaccion.getFecha() );
        objeto.put( "total", transaccion.getTotal() );
        objeto.put( "usuario_evaluado", transaccion.getEvaluado() );
        for( Integer id : transaccion.getPublicaciones() ) {
            objeto.put( "claves_productos", id );
        }
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
