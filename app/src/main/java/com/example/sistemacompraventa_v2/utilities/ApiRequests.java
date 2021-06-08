package com.example.sistemacompraventa_v2.utilities;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sistemacompraventa_v2.R;
import com.example.sistemacompraventa_v2.entidades.Usuario;

import org.json.JSONObject;

public class ApiRequests {
    private String loginURL = "http://192.168.1.68:5000/login";
    private String usuariosURL = "http://192.168.1.68:5000/usuarios";
    private ObjetosJson objetos = null;
    private RequestQueue request = null;

    public ApiRequests() {
        objetos = new ObjetosJson();
    }

    public void Login( final Context currentContext, final String usuario, final String contrasena ) {

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

/*
    public void RegisterUser( final Context currentContext, final Usuario usuario ) {
        request = Volley.newRequestQueue( currentContext );
        request.getCache().clear();
        JsonArrayRequest objectRequest = new JsonArrayRequest( Request.Method.GET, usuariosURL, null, new Response.Listener< JSONArray >(){
           @Override
           public void onResponse( JSONArray response ) {
               Toast.makeText( currentContext, response.toString(), Toast.LENGTH_SHORT ).show();
           } }, new Response.ErrorListener() {
               @Override
               public void onErrorResponse( VolleyError error ) {
                   String msg = error.getMessage();
                   Toast.makeText( currentContext, msg, Toast.LENGTH_SHORT ).show();
                }
            }
        );
        request.add( objectRequest );
    };
*/
}
