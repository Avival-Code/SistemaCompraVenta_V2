package com.example.sistemacompraventa_v2.utilities;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sistemacompraventa_v2.MainActivity;
import com.example.sistemacompraventa_v2.R;
import com.example.sistemacompraventa_v2.entidades.Usuario;
import com.example.sistemacompraventa_v2.sesionusuario.LoginSession;

import org.json.JSONObject;

public class ApiRequests {
    private String loginURL = "http://192.168.1.68:5000/login";
    private String usuariosURL = "http://192.168.1.68:5000/usuarios";
    private ObjetosJson objetos = null;
    private RequestQueue request = null;

    public ApiRequests() {
        objetos = new ObjetosJson();
    }

    public void Login( final Activity currentActivity, final String usuario, final String contrasena ) {
        request = Volley.newRequestQueue( currentActivity.getBaseContext() );
        try {
            JSONObject payload = objetos.crearObjetoJson( usuario, contrasena );
            JsonObjectRequest objectRequest = new JsonObjectRequest( Request.Method.POST, loginURL, payload, new Response.Listener< JSONObject >() {
                @Override
                public void onResponse( JSONObject response ) {
                    if( response != null ) {
                        LoginSession.GetInstance().Login( response.optInt( "clave_usuario" ), response.optString( "access_token" ) );
                        ( ( MainActivity )currentActivity ).setUserMenu();
                        Toast.makeText( currentActivity.getBaseContext(), R.string.login_exitoso, Toast.LENGTH_SHORT ).show();
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

    public void RegisterUser( final Context currentContext, final Usuario usuario ) {
        request = Volley.newRequestQueue( currentContext );
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
}
