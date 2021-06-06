package com.example.sistemacompraventa_v2.api;

import android.app.Activity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sistemacompraventa_v2.entidades.Usuario;
import com.google.gson.Gson;

public class ApiRequests {
    private String loginURL = "http://192.168.1.68:5000/login";
    private String usuariosURL = "http://192.168.1.68:5000/usuarios";
    private Gson jsonConverter = null;
    private RequestQueue request = null;

    public ApiRequests() {
        jsonConverter = new Gson();
    }

    public void RegisterUser( Activity currentActivity, Usuario usuario ) {
        request = Volley.newRequestQueue( currentActivity );
        JsonObjectRequest jsonRequest = new JsonObjectRequest(
                Request.Method.POST, usuariosURL, jsonConverter.toJson( usuario ),
        );
    }
}
