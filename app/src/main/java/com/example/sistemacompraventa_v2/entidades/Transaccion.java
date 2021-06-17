package com.example.sistemacompraventa_v2.entidades;

public class Transaccion {
    private int claveTransaccion;
    private int claveVendedor;
    private String direccionComprador;
    private String fecha;
    private double total;

    public Transaccion() {
        claveTransaccion = 0;
        claveVendedor = 0;
        direccionComprador = "";
        fecha = "";
        total = 0.0;
    }

    public Transaccion( Transaccion original ) {
        claveTransaccion = original.claveTransaccion;
        claveVendedor = original.claveVendedor;
        direccionComprador = original.direccionComprador;
        fecha = original.fecha;
        total = original.total;
    }

    public Transaccion( int claveTransaccionIn, int claveVendedorIn, String direccionIn, String fechaIn, double totalIn ) {
        claveTransaccion = claveTransaccionIn;
        claveVendedor = claveVendedorIn;
        direccionComprador = direccionIn;
        fecha = fechaIn;
        total = totalIn;
    }

    public int getClaveTransaccion() { return claveTransaccion; }

    public int getClaveVendedor() { return claveVendedor; }

    public String getDireccionComprador() { return direccionComprador; }

    public String getFecha() { return fecha; }

    public double getTotal() { return total; }
}
