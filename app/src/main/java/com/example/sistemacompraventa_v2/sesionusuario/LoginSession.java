package com.example.sistemacompraventa_v2.sesionusuario;

import com.example.sistemacompraventa_v2.entidades.Usuario;

public final class LoginSession {
    private static LoginSession loginInstance;
    private int claveUsuario;
    private String accessToken;
    private Usuario usuario;

    private LoginSession() {
        claveUsuario = -1;
        accessToken = "";
        usuario = null;
    }

    public static LoginSession GetInstance() {
        if( loginInstance == null ) {
            loginInstance = new LoginSession();
        }
        return loginInstance;
    }

    public boolean IsLoggedIn() {
        return claveUsuario != -1;
    }

    public void Logout() {
        if( IsLoggedIn() ) {
            claveUsuario = -1;
            accessToken = "";
            usuario = null;
        }
    }

    public void Login( int claveIn, String tokenIn ) {
        if( !IsLoggedIn() && claveUsuario != -1 ) {
            claveUsuario = claveIn;
            accessToken = tokenIn;
        }
    }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario( Usuario usuarioIn ) { usuario = usuarioIn; }

    public String getAccessToken() { return accessToken; }
}
