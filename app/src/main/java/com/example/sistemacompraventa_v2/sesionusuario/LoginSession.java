package com.example.sistemacompraventa_v2.sesionusuario;

import com.example.sistemacompraventa_v2.entidades.Publicacion;
import com.example.sistemacompraventa_v2.entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

public final class LoginSession {
    private static LoginSession loginInstance;
    private List< Publicacion > articulosCarrito;
    private List< Publicacion > articulosFavoritos;
    private Usuario usuario;
    private int claveUsuario;
    private String accessToken;

    private LoginSession() {
        articulosCarrito = null;
        articulosFavoritos = null;
        usuario = null;
        claveUsuario = -1;
        accessToken = "";
    }

    public static LoginSession getInstance() {
        if( loginInstance == null ) {
            loginInstance = new LoginSession();
        }
        return loginInstance;
    }

    public boolean isLoggedIn() {
        return claveUsuario > -1;
    }

    public void logout() {
        if( isLoggedIn() ) {
            claveUsuario = -1;
            accessToken = "";
            usuario = null;
        }
    }

    public void login(int claveIn, String tokenIn ) {
        if( !isLoggedIn() && claveUsuario == -1 ) {
            claveUsuario = claveIn;
            accessToken = tokenIn;
        }
    }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario( Usuario usuarioIn ) { usuario = usuarioIn; }

    public List< Publicacion > getArticulosCarrito() { return articulosCarrito; }

    public void setArticulosCarrito( List< Publicacion > articulosIn ) { articulosCarrito = articulosIn; }

    public void eliminarArticuloCarrito( int claveArticulo ) {
        for( int currentItem = 0; currentItem < articulosCarrito.size(); currentItem++ ) {
            if( articulosCarrito.get( currentItem ).getClave_publicacion() == claveArticulo ) {
                articulosCarrito.remove( currentItem );
            }
        }
    }

    public List< Publicacion > getArticulosFavoritos() { return articulosFavoritos; }

    public void setArticulosFavoritos( List< Publicacion > articulosIn ) { articulosFavoritos = articulosIn; }

    public void eliminarArticuloFavorito( int claveArticulo ) {
        for( int currentItem = 0; currentItem < articulosFavoritos.size(); currentItem++ ) {
            if( articulosFavoritos.get( currentItem ).getClave_publicacion() == claveArticulo ) {
                articulosFavoritos.remove( currentItem );
            }
        }
    }

    public int getClaveUsuario() { return claveUsuario; }

    public String getAccessToken() { return accessToken; }
}
