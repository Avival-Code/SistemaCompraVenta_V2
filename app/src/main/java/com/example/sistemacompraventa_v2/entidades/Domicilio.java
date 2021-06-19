package com.example.sistemacompraventa_v2.entidades;

public class Domicilio {
    private int discriminante_domicilio;
    private int clave_usuario;
    private String calle;
    private String colonia;
    private String municipio;
    private String codigo_postal;
    private String estado;
    private int numero_interno;
    private int numero_externo;
    private String descripcion;

    public Domicilio() {
        discriminante_domicilio = -1;
        clave_usuario = -1;
        calle = "";
        colonia = "";
        municipio = "";
        codigo_postal = "";
        estado = "";
        numero_externo = -1;
        numero_interno = -1;
        descripcion = "";
    }

    public Domicilio( Domicilio original ) {
        discriminante_domicilio = original.discriminante_domicilio;
        clave_usuario = original.clave_usuario;
        calle = original.calle;
        colonia = original.colonia;
        municipio = original.municipio;
        codigo_postal = original.codigo_postal;
        estado = original.estado;
        numero_externo = original.numero_externo;
        numero_interno = original.numero_interno;
        descripcion = original.descripcion;
    }

    public Domicilio( int discriminanteIn, int claveUsuarioIn, String calleIn, String coloniaIn, String municipioIn, String codigoIn,
                      String estadoIn, int numInternoIn, int numExternoIn, String descripcionIn ) {
        discriminante_domicilio = discriminanteIn;
        clave_usuario = claveUsuarioIn;
        calle = calleIn;
        colonia = coloniaIn;
        municipio = municipioIn;
        codigo_postal = codigoIn;
        estado = estadoIn;
        numero_externo = numExternoIn;
        numero_interno = numInternoIn;
        descripcion = descripcionIn;
    }

    public int getDiscriminante() { return discriminante_domicilio; }

    public int getClaveUsuario() { return clave_usuario; }

    public String getCalle() { return calle; }

    public String getColonia() { return colonia; }

    public String getMunicipio() { return municipio; }

    public String getCodigo() { return codigo_postal; }

    public String getEstado() { return estado; }

    public int getNumerInterno() { return numero_interno; }

    public int getNumeroExterno() { return numero_externo; }

    public String getDescripcion() { return descripcion; }
}
