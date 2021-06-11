package com.example.sistemacompraventa_v2.entidades;

import com.example.sistemacompraventa_v2.enumeraciones.Categoria;

public class Publicacion {
    private int clave_publicacion;
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private double precio;
    private int cantidad_disponible;
    private double calificacion_general;
    private String unidad_medida;
    private int numero_ventas;
    private String imagen;

    public Publicacion() {
        clave_publicacion = 0;
        nombre = "";
        descripcion = "";
        categoria = null;
        precio = 0.0f;
        cantidad_disponible = -1;
        calificacion_general = 0.0f;
        unidad_medida = "";
        numero_ventas = 0;
        imagen = "";
    }

    public Publicacion( Publicacion original ) {
        clave_publicacion = original.clave_publicacion;
        nombre = original.nombre;
        descripcion = original.descripcion;
        categoria = original.categoria;
        precio = original.precio;
        cantidad_disponible = original.cantidad_disponible;
        calificacion_general = original.calificacion_general;
        unidad_medida = original.unidad_medida;
        numero_ventas = original.numero_ventas;
        imagen = original.imagen;
    }

    public Publicacion( int claveIn, String nombreIn, String descripcionIn, Categoria categoriaIn,
                        double precioIn, int cantidadIn, double calificacionIn, String unidadIn, int ventasIn, String imagenIn  ) {
        clave_publicacion = claveIn;
        nombre = nombreIn;
        descripcion = descripcionIn;
        categoria = categoriaIn;
        precio = precioIn;
        cantidad_disponible = cantidadIn;
        calificacion_general = calificacionIn;
        unidad_medida = unidadIn;
        numero_ventas = ventasIn;
        imagen = imagenIn;
    }

    public int getClave_publicacion() { return clave_publicacion; }

    public String getNombre() { return nombre; }

    public String getDescripcion() { return descripcion; }

    public Categoria getCategoria() { return categoria; }

    public double getPrecio() { return precio; }

    public int getCantidad_disponible() { return cantidad_disponible; }

    public double getCalificacion_general() { return calificacion_general; }

    public String getUnidad_medida() { return unidad_medida; }

    public int getNumero_ventas() { return numero_ventas; }

    public String getImagen() { return imagen; }

    public void setNombre(String nombre) { nombre = nombre; }

    public void setDescripcion( String descripcionIn ) { descripcion = descripcionIn; }

    public void setCategoria( Categoria categoriaIn ) { categoria = categoriaIn; }

    public void setPrecio( double precioIn ) { precio = precioIn; }

    public void setCantidad_disponible( int cantidad_disponibleIn ) { cantidad_disponible = cantidad_disponibleIn; }

    public void setCalificacion_general( double calificacion_generalIn ) { calificacion_general = calificacion_generalIn; }

    public void setUnidad_medida( String unidad_medidaIn ) { unidad_medida = unidad_medidaIn; }

    public void setNumero_ventas( int numero_ventasIn ) { numero_ventas = numero_ventasIn; }

    public void setImagen( String imagenIn ) { imagen = imagenIn; }
}