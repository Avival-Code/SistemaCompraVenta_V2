package com.example.sistemacompraventa_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sistemacompraventa_v2.entidades.EvaluacionUsuario;
import com.example.sistemacompraventa_v2.sesionusuario.LoginSession;
import com.example.sistemacompraventa_v2.utilities.ApiRequests;

public class EvaluarUsuarioActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText contenidoEvaluacion;
    private Button mandarEvaluacionBoton;
    private int claveUsuarioEvaluado;
    private boolean evaluacionEnviada;
    private ApiRequests requests;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.evaluar_usuario_activity );

        evaluacionEnviada = false;
        requests = new ApiRequests();
        contenidoEvaluacion = findViewById( R.id.contenidoEvaluacion );
        mandarEvaluacionBoton = findViewById( R.id.mandarEvaluacionUsuarioButton );
        claveUsuarioEvaluado = getIntent().getIntExtra( "clave_vendedor", -1 );
    }

    @Override
    public void onClick( View view ) {
        switch( view.getId() ) {
            case R.id.mandarEvaluacionUsuarioButton:
                if( !evaluacionEnviada ) {
                    requests.sendEvaluacionUsuario( this, LoginSession.getInstance().getClaveUsuario(), getEvaluacion(), LoginSession.getInstance().getAccessToken() );
                    evaluacionEnviada = true;
                } else {
                    Toast.makeText( this, R.string.evaluacion_ya_fue_enviada, Toast.LENGTH_SHORT ).show();
                }
                break;
        }
    }

    private EvaluacionUsuario getEvaluacion( ){
        return new EvaluacionUsuario();
    }
}