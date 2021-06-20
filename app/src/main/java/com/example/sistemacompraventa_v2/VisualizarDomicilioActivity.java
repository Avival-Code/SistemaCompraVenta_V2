package com.example.sistemacompraventa_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sistemacompraventa_v2.entidades.Domicilio;
import com.example.sistemacompraventa_v2.entidades.Publicacion;
import com.example.sistemacompraventa_v2.enumeraciones.Categoria;
import com.example.sistemacompraventa_v2.sesionusuario.LoginSession;
import com.example.sistemacompraventa_v2.utilities.ApiRequests;

public class VisualizarDomicilioActivity extends AppCompatActivity implements View.OnClickListener {
    private ApiRequests requests;
    private TextView calle;
    private TextView colonia;
    private TextView municipio;
    private TextView codigo;
    private TextView estado;
    private TextView numInterno;
    private TextView numExterno;
    private TextView descripcion;
    private Button eliminarDomicilio;
    private Domicilio domicilio;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.visualizar_domicilio_activity );

        requests = new ApiRequests();
        calle = findViewById( R.id.calle_visualizar_text );
        colonia = findViewById( R.id.colonia_visualizar_text );
        municipio = findViewById( R.id.municipio_visualizar_text );
        codigo = findViewById( R.id.codigo_visualizar_text );
        estado = findViewById( R.id.estado_visualizar_text );
        numInterno = findViewById( R.id.numinterno_visualizar_text );
        numExterno = findViewById( R.id.numexterno_visualizar_text );
        descripcion = findViewById( R.id.descripcion_visualizar_text );
        eliminarDomicilio = findViewById( R.id.eliminar_domicilio_button );
        eliminarDomicilio.setOnClickListener( this );

        GetData();
        SetData();
    }

    @Override
    public void onClick( View view ) {
        switch( view.getId() ) {
            case R.id.eliminar_domicilio_button:
                if( domicilio != null ) {
                    requests.eliminarDomicilioUsuario( this, LoginSession.getInstance().getClaveUsuario(),
                                                       domicilio.getDiscriminante(), LoginSession.getInstance().getAccessToken() );
                } else {
                    Toast.makeText( this, R.string.domicilio_vacio_visualizar, Toast.LENGTH_SHORT ).show();
                }
                break;
        }
    }

    private void GetData() {
        if( getIntent().hasExtra( "discriminante_domicilio" ) && getIntent().hasExtra( "clave_usuario" ) &&
                getIntent().hasExtra( "calle") && getIntent().hasExtra( "colonia" ) &&
                getIntent().hasExtra( "municipio" ) && getIntent().hasExtra( "codigo_postal" ) &&
                getIntent().hasExtra( "estado" ) && getIntent().hasExtra( "numero_interno" ) &&
                getIntent().hasExtra( "numero_externo" ) && getIntent().hasExtra( "descripcion" ) ) {
            domicilio = new Domicilio( getIntent().getIntExtra( "discriminante_domicilio", 1 ), getIntent().getIntExtra( "clave_usuario", 1 ),
                    getIntent().getStringExtra( "calle" ), getIntent().getStringExtra( "colonia" ),
                    getIntent().getStringExtra( "municipio" ), getIntent().getStringExtra( "codigo_postal" ),
                    getIntent().getStringExtra( "estado" ), Integer.parseInt( getIntent().getStringExtra( "numero_interno" ) ),
                    Integer.parseInt( getIntent().getStringExtra( "numero_externo" ) ), getIntent().getStringExtra( "descripcion" ) );
        } else {
            Toast.makeText( this, R.string.no_hay_datos, Toast.LENGTH_SHORT ).show();
        }
    }

    private void SetData() {
        calle.setText( domicilio.getCalle() );
        colonia.setText( domicilio.getColonia() );
        municipio.setText( domicilio.getMunicipio() );
        codigo.setText( domicilio.getCodigo() );
        estado.setText( domicilio.getEstado() );
        numInterno.setText( domicilio.getNumerInterno() );
        numExterno.setText( domicilio.getNumeroExterno() );
        descripcion.setText( domicilio.getDescripcion() );
    }
}