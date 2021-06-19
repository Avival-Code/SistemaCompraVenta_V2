package com.example.sistemacompraventa_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sistemacompraventa_v2.entidades.Domicilio;
import com.example.sistemacompraventa_v2.sesionusuario.LoginSession;
import com.example.sistemacompraventa_v2.utilities.ApiRequests;
import com.example.sistemacompraventa_v2.utilities.StringValidator;

public class CrearDomicilioActivity extends AppCompatActivity implements View.OnClickListener {
    private Button crearDomiclioButton;
    private ApiRequests requests;
    private StringValidator validator;
    private Domicilio domicilio;
    private boolean mandeDomicilio;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.crear_domicilio_activity );

        requests = new ApiRequests();
        validator = new StringValidator();
        crearDomiclioButton = findViewById( R.id.crear_domicilio_button );
        crearDomiclioButton.setOnClickListener( this );
        mandeDomicilio = false;
    }

    @Override
    public void onClick( View view ) {
        switch( view.getId() ) {
            case R.id.crear_domicilio_button:
                CheckUserInput();
                domicilio = CreateDomicilio();
                if( !mandeDomicilio && validator.IsDomicilioInformationValid( domicilio ) ) {
                    mandeDomicilio = true;
                    requests.agregarDomicilio( getBaseContext(), LoginSession.getInstance().getClaveUsuario(), domicilio, LoginSession.getInstance().getAccessToken() );
                }
                break;
        }
    }

    private void CheckUserInput() {
        CheckCalle();
        CheckColonia();
        CheckMunicipio();
        CheckCodigoPostal();
        CheckEstado();
        CheckNumeroInterno();
        CheckNumeroExterno();
        CheckDescripcion();
    }

    private void CheckCalle() {
        if ( !validator.IsDomicilioStringValid( ( ( EditText )findViewById( R.id.calle_input_text ) ).getText().toString() ) ) {
            Toast.makeText( this, R.string.calle_invalid, Toast.LENGTH_SHORT ).show();
        }
    }

    private void CheckColonia() {
        if ( !validator.IsDomicilioStringValid( ( ( EditText )findViewById( R.id.colonia_input_text ) ).getText().toString() ) ) {
            Toast.makeText( this, R.string.colonia_invalid, Toast.LENGTH_SHORT ).show();
        }
    }

    private void CheckMunicipio() {
        if ( !validator.IsDomicilioStringValid( ( ( EditText )findViewById( R.id.municipio_input_text ) ).getText().toString() ) ) {
            Toast.makeText( this, R.string.municipio_invalid, Toast.LENGTH_SHORT ).show();
        }
    }

    private void CheckCodigoPostal() {
        if ( !validator.IsDomicilioStringValid( ( ( EditText )findViewById( R.id.codigo_input_text ) ).getText().toString() ) ) {
            Toast.makeText( this, R.string.estado_invalid, Toast.LENGTH_SHORT ).show();
        }
    }

    private void CheckEstado() {
        if ( !validator.IsDomicilioStringValid( ( ( EditText )findViewById( R.id.estado_input_text ) ).getText().toString() ) ) {
            Toast.makeText( this, R.string.estado_invalid, Toast.LENGTH_SHORT ).show();
        }
    }

    private void CheckNumeroInterno() {
        if ( !validator.IsDomilicioNumberValid( ( ( EditText )findViewById( R.id.numinterno_input_text ) ).getText().toString() ) ) {
            Toast.makeText( this, R.string.numerointerno_invalid, Toast.LENGTH_SHORT ).show();
        }
    }

    private void CheckNumeroExterno() {
        if ( !validator.IsDomilicioNumberValid( ( ( EditText )findViewById( R.id.numexterno_input_text ) ).getText().toString() ) ) {
            Toast.makeText( this, R.string.numeroexterno_invalid, Toast.LENGTH_SHORT ).show();
        }
    }

    private void CheckDescripcion() {
        if ( !validator.IsDomicilioDescripcionValid( ( ( EditText )findViewById( R.id.descripcion_input_text ) ).getText().toString() ) ) {
            Toast.makeText( this, R.string.descripcion_invalid, Toast.LENGTH_SHORT ).show();
        }
    }

    private Domicilio CreateDomicilio() {
        return new Domicilio( 0, LoginSession.getInstance().getClaveUsuario(),
                            ( ( EditText )findViewById( R.id.calle_input_text ) ).getText().toString(),
                            ( ( EditText )findViewById( R.id.colonia_input_text ) ).getText().toString(),
                            ( ( EditText )findViewById( R.id.municipio_input_text ) ).getText().toString(),
                            ( ( EditText )findViewById( R.id.codigo_input_text ) ).getText().toString(),
                            ( ( EditText )findViewById( R.id.estado_input_text ) ).getText().toString(),
                            Integer.parseInt( ( ( EditText )findViewById( R.id.numinterno_input_text ) ).getText().toString() ),
                            Integer.parseInt( ( ( EditText )findViewById( R.id.numexterno_input_text ) ).getText().toString() ),
                            ( ( EditText )findViewById( R.id.descripcion_input_text ) ).getText().toString());
    }
}