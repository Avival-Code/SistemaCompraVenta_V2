package com.example.sistemacompraventa_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sistemacompraventa_v2.entidades.Domicilio;
import com.example.sistemacompraventa_v2.entidades.Publicacion;
import com.example.sistemacompraventa_v2.enumeraciones.Categoria;
import com.example.sistemacompraventa_v2.sesionusuario.LoginSession;
import com.example.sistemacompraventa_v2.utilities.ApiRequests;
import com.example.sistemacompraventa_v2.utilities.StringValidator;

public class CrearPublicacionActivity extends AppCompatActivity implements View.OnClickListener{
    private ApiRequests requests;
    private StringValidator validator;
    private Button publicarButton;
    private boolean creoPublicacion;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.crear_publicacion_activity );

        creoPublicacion = false;
        requests = new ApiRequests();
        validator = new StringValidator();
        publicarButton = findViewById( R.id.publicar_publicacion_button );
        publicarButton.setOnClickListener( this );
    }

    @Override
    public void onClick( View view ) {
        switch( view.getId() ) {
            case R.id.crear_publicacion_button:
                CheckUserInput();
                if( !creoPublicacion && validator.IsPublicacionInformationValid( CreatePublicacion() ) ) {
                    creoPublicacion = true;
                    
                }
                break;
        }
    }

    private void CheckUserInput() {
        CheckNombre();
        CheckDescripcion();
        CheckCategoria();
        CheckPrecio();
        CheckCantidadDisponible();
        CheckUnidadMedida();
    }

    private void CheckNombre() {
        if ( !validator.IsDomicilioStringValid( ( (EditText)findViewById( R.id.nombre_crear_publicacion ) ).getText().toString() ) ) {
            Toast.makeText( this, R.string.nombre_publicacion_invalido, Toast.LENGTH_SHORT ).show();
        }
    }

    private void CheckDescripcion() {
        if ( !validator.IsDomicilioStringValid( ( ( EditText )findViewById( R.id.descripcion_crear_publicacion ) ).getText().toString() ) ) {
            Toast.makeText( this, R.string.descripcion_publicacion_invalido, Toast.LENGTH_SHORT ).show();
        }
    }

    private void CheckCategoria() {
        if ( !validator.IsDomicilioStringValid( ( ( EditText )findViewById( R.id.categoria_crear_publicacion ) ).getText().toString() ) ) {
            Toast.makeText( this, R.string.categoria_publicacion_invalido, Toast.LENGTH_SHORT ).show();
        }
    }

    private void CheckPrecio() {
        if ( !validator.IsDomicilioStringValid( ( ( EditText )findViewById( R.id.precio_crear_publicacion ) ).getText().toString() ) ) {
            Toast.makeText( this, R.string.precio_publicacion_invalido, Toast.LENGTH_SHORT ).show();
        }
    }

    private void CheckCantidadDisponible() {
        if ( !validator.IsDomicilioStringValid( ( ( EditText )findViewById( R.id.cantidad_crear_publicacion ) ).getText().toString() ) ) {
            Toast.makeText( this, R.string.cantidad_publicacion_invalido, Toast.LENGTH_SHORT ).show();
        }
    }

    private void CheckUnidadMedida() {
        if ( !validator.IsDomilicioNumberValid( ( ( EditText )findViewById( R.id.unidad_crear_producto ) ).getText().toString() ) ) {
            Toast.makeText( this, R.string.unidad_publicacion_invalido, Toast.LENGTH_SHORT ).show();
        }
    }

    private Publicacion CreatePublicacion() {
        return new Publicacion( 0,
                ( ( EditText )findViewById( R.id.nombre_crear_publicacion ) ).getText().toString(),
                ( ( EditText )findViewById( R.id.descripcion_crear_publicacion ) ).getText().toString(),
                Categoria.tecnologia,
                Double.parseDouble( ( ( EditText )findViewById( R.id.precio_crear_publicacion ) ).getText().toString() ),
                Integer.parseInt( ( ( EditText )findViewById( R.id.cantidad_crear_publicacion ) ).getText().toString() ),
                0.0f,
                ( ( EditText )findViewById( R.id.unidad_crear_producto ) ).getText().toString(), 0, "" );
    }
}