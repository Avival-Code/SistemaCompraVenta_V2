package com.example.sistemacompraventa_v2.entidades;

public class EvaluacionUsuario {
    private int discriminante_evaluacion;
    private int clave_usuario;
    private int clave_evaluador_de_usuario;
    private String evaluacion;
    private int calificacion;

    public EvaluacionUsuario() {
        discriminante_evaluacion = 0;
        clave_usuario = 0;
        clave_evaluador_de_usuario = 0;
        evaluacion = "";
        calificacion = 0;
    }

    public EvaluacionUsuario( EvaluacionUsuario original ) {
        discriminante_evaluacion = original.discriminante_evaluacion;
        clave_usuario = original.clave_usuario;
        clave_evaluador_de_usuario = original.clave_evaluador_de_usuario;
        evaluacion = original.evaluacion;
        calificacion = original.calificacion;
    }

    public EvaluacionUsuario( int discriminanteIn, int claveUsuarioIn, int claveEvaluadorIn, String evaluacionIn,
                              int calificacionIn ) {
        discriminante_evaluacion = discriminanteIn;
        clave_usuario = claveUsuarioIn;
        clave_evaluador_de_usuario = claveEvaluadorIn;
        evaluacion = evaluacionIn;
        calificacion = calificacionIn;
    }

    public int getDiscriminanteEvaluacion() { return discriminante_evaluacion; }

    public int getClaveUsuario() { return clave_usuario; }

    public int getClaveEvaluador() { return clave_evaluador_de_usuario; }

    public String getEvaluacion() { return evaluacion; }

    public int getCalificacion() { return calificacion; }
}
