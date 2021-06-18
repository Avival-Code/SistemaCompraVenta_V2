package com.example.sistemacompraventa_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EvaluarUsuarioActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText contenidoEvaluacion;
    private Button mandarEvaluacionBoton;
    private int claveUsuarioEvaluado;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.evaluar_usuario_activity );

        contenidoEvaluacion = findViewById( R.id.contenidoEvaluacion );
        mandarEvaluacionBoton = findViewById( R.id.mandarEvaluacionUsuarioButton );
        claveUsuarioEvaluado = getIntent().getIntExtra( "clave_vendedor", -1 );
    }

    @Override
    public void onClick( View view ) {
        switch( view.getId() ) {
            case R.id.mandarEvaluacionUsuarioButton:
                break;
        }
    }
}