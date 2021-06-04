package com.example.sistemacompraventa_v2.sesionusuario;

import com.example.sistemacompraventa_v2.entidades.Usuario;

public final class LoginSession {
    private static LoginSession loginInstance;
    private Usuario usuario;

    private LoginSession() { usuario = null; }

    public static LoginSession GetInstance() {
        if( loginInstance == null ) {
            loginInstance = new LoginSession();
        }
        return loginInstance;
    }

    public boolean IsLoggedIn() {
        return usuario != null;
    }

    public void Logout() {
        if( IsLoggedIn() ) {
            usuario = null;
        }
    }

    public void Login( Usuario usuarioIn ) {
        if( !IsLoggedIn() && usuarioIn != null ) {
            usuario = usuarioIn;
        }
    }

    public Usuario GetUsuario() { return usuario; }
}
