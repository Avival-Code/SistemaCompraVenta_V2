package com.example.sistemacompraventa_v2.utilities;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sistemacompraventa_v2.MainActivity;
import com.example.sistemacompraventa_v2.R;
import com.example.sistemacompraventa_v2.entidades.Usuario;
import com.example.sistemacompraventa_v2.enumeraciones.TipoUsuario;
import com.example.sistemacompraventa_v2.sesionusuario.LoginSession;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ApiRequests {
    private String loginURL = "http://192.168.1.68:5000/login";
    private String usuariosURL = "http://192.168.1.68:5000/usuarios";
    private String usuarioEspecificoURL = "http://192.168.1.68:5000/usuarios/";
    private ObjetosJson objetos = null;

    public ApiRequests() {
        objetos = new ObjetosJson();
    }

    public void login( final Activity currentActivity, final String usuario, final String contrasena ) {
        RequestQueue request = Volley.newRequestQueue( currentActivity.getBaseContext() );
        try {
            JSONObject payload = objetos.crearObjetoJson( usuario, contrasena );
            JsonObjectRequest objectRequest = new JsonObjectRequest( Request.Method.POST, loginURL, payload, new Response.Listener< JSONObject >() {
                @Override
                public void onResponse( JSONObject response ) {
                    if( response != null ) {
                        LoginSession.getInstance().login( response.optInt( "clave_usuario" ), response.optString( "access_token" ) );
                        ( ( MainActivity )currentActivity ).setUserMenu();
                        Toast.makeText( currentActivity.getBaseContext(), R.string.login_exitoso, Toast.LENGTH_SHORT ).show();
                        getUsuario( currentActivity.getBaseContext(), LoginSession.getInstance().getClaveUsuario(), LoginSession.getInstance().getAccessToken() );
                    } else {
                        Toast.makeText( currentActivity.getBaseContext(), R.string.usuario_no_encontrado, Toast.LENGTH_SHORT ).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse( VolleyError error ) {
                    Toast.makeText( currentActivity.getBaseContext(), R.string.login_fracaso, Toast.LENGTH_SHORT ).show();
                }
            } );
            request.add( objectRequest );
        } catch( org.json.JSONException json ) {
            json.printStackTrace();
        }
    }

    public void registrarUsuario(final Context currentContext, final Usuario usuario ) {
        RequestQueue request = Volley.newRequestQueue( currentContext );
        try {
            JSONObject payload = objetos.crearObjectoJson( usuario );
            JsonObjectRequest objectRequest = new JsonObjectRequest( Request.Method.POST, usuariosURL, payload, new Response.Listener< JSONObject >() {
                @Override
                public void onResponse( JSONObject response ) {
                    Toast.makeText( currentContext, R.string.usuario_creado_exito, Toast.LENGTH_SHORT ).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse( VolleyError error ) {
                    Toast.makeText( currentContext, R.string.usuario_ya_existe, Toast.LENGTH_SHORT ).show();
                }
            } );
            request.add( objectRequest );
        } catch( org.json.JSONException json ) {
            json.printStackTrace();
        }
    }

    public void getUsuario(final Context currentContext, final int claveUsuario, final String accessToken ) {
        RequestQueue request = Volley.newRequestQueue( currentContext );
        try {
            String requestURL = usuarioEspecificoURL + claveUsuario;
            JsonObjectRequest objectRequest = new JsonObjectRequest( Request.Method.GET, requestURL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse( JSONObject response ) {
                    if( response != null ) {
                        Usuario temp = new Usuario( response.optInt( "clave_usuario" ), response.optString( "nombres" ), response.optString( "apellidos" ),
                                response.optString( "correo_electronico" ), response.optString("telefono" ), response.optString( "nombre_usuario" ),
                                response.optString( "contrasena" ), ( float )response.optDouble( "calificacion" ), TipoUsuario.values() [ response.optInt( "tipo_usuario" ) ] );
                        LoginSession.getInstance().setUsuario( temp );
                    } else {
                        Toast.makeText( currentContext, R.string.usuario_no_encontrado, Toast.LENGTH_SHORT ).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse( VolleyError error ) {
                    Toast.makeText( currentContext, R.string.clave_usuario_no_encontrada, Toast.LENGTH_SHORT ).show();
                }
            } ) {
                @Override
                public Map< String, String > getHeaders() throws AuthFailureError {
                    HashMap< String, String > headers = new HashMap< String, String > ();
                    headers.put( "Authorization", "Bearer " + accessToken );
                    return headers;
                }
            };
            request.add( objectRequest );
        } catch( Exception exception ) { exception.printStackTrace(); }
    }

    public void actualizarUsuario( final Context currentContext, final Usuario usuario, final String accessToken ) {
        RequestQueue request = Volley.newRequestQueue( currentContext );
        try {
            String requestURL = usuarioEspecificoURL + usuario.getClaveUsuario();
            JSONObject payload = objetos.crearObjectoJson( usuario );
            JsonObjectRequest objectRequest = new JsonObjectRequest( Request.Method.PUT, requestURL, payload, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse( JSONObject response ) {
                    Toast.makeText( currentContext, R.string.actualizacion_exitosa, Toast.LENGTH_SHORT ).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse( VolleyError error ) {
                    Toast.makeText( currentContext, R.string.clave_usuario_no_encontrada, Toast.LENGTH_SHORT ).show();
                }
            } ) {
                @Override
                public Map< String, String > getHeaders() throws AuthFailureError {
                    HashMap< String, String > headers = new HashMap< String, String > ();
                    headers.put( "Authorization", "Bearer " + accessToken );
                    return headers;
                }
            };
            request.add( objectRequest );
        } catch( Exception exception ) { exception.printStackTrace(); }
    }

    public void eliminarUsuario( final Activity currentActivity, final int claveUsuario, final String accessToken ) {
        RequestQueue request = Volley.newRequestQueue( currentActivity.getBaseContext() );
        try {
            String requestURL = usuarioEspecificoURL + claveUsuario;
            JsonObjectRequest objectRequest = new JsonObjectRequest( Request.Method.DELETE, requestURL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse( JSONObject response ) {
                    LoginSession.getInstance().logout();
                    ( ( MainActivity )currentActivity ).setNonUserMenu();
                    Toast.makeText( currentActivity.getBaseContext(), R.string.eliminacion_exitosa, Toast.LENGTH_SHORT ).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse( VolleyError error ) {
                    Toast.makeText( currentActivity.getBaseContext(), R.string.clave_usuario_no_encontrada, Toast.LENGTH_SHORT ).show();
                }
            } ) {
                @Override
                public Map< String, String > getHeaders() throws AuthFailureError {
                    HashMap< String, String > headers = new HashMap< String, String > ();
                    headers.put( "Authorization", "Bearer " + accessToken );
                    return headers;
                }
            };
            request.add( objectRequest );
        } catch( Exception exception ) { exception.printStackTrace(); }
    }
}
