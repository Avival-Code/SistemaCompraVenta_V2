package com.example.sistemacompraventa_v2.sesionusuario;

public final class LoginSession {
    private static LoginSession loginInstance;

    private LoginSession() {

    }

    public static LoginSession GetInstance() {
        if( loginInstance == null ) {
            loginInstance = new LoginSession();
        }
        return loginInstance;
    }

    public boolean IsLoggedIn() {
        return loginInstance == null;
    }

    public void Logout() {
        loginInstance = null;
    }

    public void Login() {

    }
}
