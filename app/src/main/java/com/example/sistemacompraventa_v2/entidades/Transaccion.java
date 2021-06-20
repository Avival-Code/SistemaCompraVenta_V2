package com.example.sistemacompraventa_v2.entidades;

import java.util.List;

public class Transaccion {
    private int clave_transaccion;
    private int clave_vendedor;
    private String direccion_comprador;
    private String fecha;
    private double total;
    private boolean usuario_evaluado;
    private List< Integer > publicaciones;

    public Transaccion() {
        clave_transaccion = 0;
        clave_vendedor = 0;
        direccion_comprador = "";
        fecha = "";
        total = 0.0;
        usuario_evaluado = false;
        publicaciones = null;
    }

    public Transaccion( Transaccion original ) {
        clave_transaccion = original.clave_transaccion;
        clave_vendedor = original.clave_vendedor;
        direccion_comprador = original.direccion_comprador;
        fecha = original.fecha;
        total = original.total;
        usuario_evaluado = original.usuario_evaluado;
        publicaciones = original.publicaciones;
    }

    public Transaccion( int claveTransaccionIn, int claveVendedorIn, String direccionIn, String fechaIn, double totalIn,
                        boolean evaluadoin, List< Integer > publicacionesIn ) {
        clave_transaccion = claveTransaccionIn;
        clave_vendedor = claveVendedorIn;
        direccion_comprador = direccionIn;
        fecha = fechaIn;
        total = totalIn;
        usuario_evaluado = evaluadoin;
        publicaciones = publicacionesIn;
    }

    public int getClaveTransaccion() { return clave_transaccion; }

    public int getClaveVendedor() { return clave_vendedor; }

    public String getDireccionComprador() { return direccion_comprador; }

    public String getFecha() { return fecha; }

    public double getTotal() { return total; }

    public boolean getEvaluado() { return usuario_evaluado; }

    public List< Integer > getPublicaciones() { return publicaciones; }
}
