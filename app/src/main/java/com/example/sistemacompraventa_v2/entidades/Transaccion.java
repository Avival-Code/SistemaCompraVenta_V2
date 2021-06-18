package com.example.sistemacompraventa_v2.entidades;

public class Transaccion {
    private int clave_transaccion;
    private int clave_vendedor;
    private String direccion_comprador;
    private String fecha;
    private double total;
    private boolean usuario_evaluado;

    public Transaccion() {
        clave_transaccion = 0;
        clave_vendedor = 0;
        direccion_comprador = "";
        fecha = "";
        total = 0.0;
        usuario_evaluado = false;
    }

    public Transaccion( Transaccion original ) {
        clave_transaccion = original.clave_transaccion;
        clave_vendedor = original.clave_vendedor;
        direccion_comprador = original.direccion_comprador;
        fecha = original.fecha;
        total = original.total;
        usuario_evaluado = original.usuario_evaluado;
    }

    public Transaccion( int claveTransaccionIn, int claveVendedorIn, String direccionIn, String fechaIn, double totalIn,
                        boolean evaluadoin ) {
        clave_transaccion = claveTransaccionIn;
        clave_vendedor = claveVendedorIn;
        direccion_comprador = direccionIn;
        fecha = fechaIn;
        total = totalIn;
        usuario_evaluado = evaluadoin;
    }

    public int getClaveTransaccion() { return clave_transaccion; }

    public int getClaveVendedor() { return clave_vendedor; }

    public String getDireccionComprador() { return direccion_comprador; }

    public String getFecha() { return fecha; }

    public double getTotal() { return total; }

    public boolean getEvaluado() { return usuario_evaluado; }
}
