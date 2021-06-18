package com.example.sistemacompraventa_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sistemacompraventa_v2.entidades.Publicacion;
import com.example.sistemacompraventa_v2.entidades.Transaccion;
import com.example.sistemacompraventa_v2.enumeraciones.Categoria;

public class VisualizarTransaccionActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView claveTransaccion;
    private TextView claveVendedor;
    private TextView fecha;
    private TextView precio;
    private Button mandarEvaluacionButton;
    private Transaccion transaccion;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.visualizar_transaccion_activity );

        claveTransaccion = findViewById( R.id.claveTransaccionText );
        claveVendedor = findViewById( R.id.claveVendedorText );
        precio = findViewById( R.id.precioTotalText );
        fecha = findViewById( R.id.fechaDeVentaText );
        mandarEvaluacionButton = findViewById( R.id.evaluarUsuarioButton );

        mandarEvaluacionButton.setOnClickListener( this );

        getData();
        setData();
    }

    private void getData() {
        if( getIntent().hasExtra( "clave_transaccion" ) && getIntent().hasExtra( "clave_vendedor" ) &&
                getIntent().hasExtra( "direccion_comprador") && getIntent().hasExtra( "fecha" ) &&
                getIntent().hasExtra( "total" ) && getIntent().hasExtra( "usuario_evaluado" ) ) {
            transaccion = new Transaccion( getIntent().getIntExtra( "clave_transaccion", 1 ), getIntent().getIntExtra( "clave_vendedor", 1 ),
                    getIntent().getStringExtra( "direccion_comprador" ), getIntent().getStringExtra( "fecha" ), getIntent().getDoubleExtra( "total", 1 ),
                    getIntent().getBooleanExtra( "usuario_evaluado", false ) );
        } else {
            Toast.makeText( this, R.string.no_hay_datos, Toast.LENGTH_SHORT ).show();
        }
    }

    private void setData() {
        claveTransaccion.setText( transaccion.getClaveTransaccion() );
        claveVendedor.setText( transaccion.getClaveVendedor() );
        precio.setText( Double.toString( transaccion.getTotal() ) );
        fecha.setText( transaccion.getFecha() );
    }

    @Override
    public void onClick( View view ) {
        switch( view.getId() ) {
            case R.id.evaluarUsuarioButton:
                if( !transaccion.getEvaluado() ) {
                    Intent intent = new Intent( getBaseContext(), EvaluarUsuarioActivity.class );
                    intent.putExtra( "clave_vendedor", transaccion.getClaveVendedor() );
                    getBaseContext().startActivity( intent );
                } else {
                    Toast.makeText( this, R.string.usuario_ya_esta_evaluado, Toast.LENGTH_SHORT ).show();
                }
                break;
        }
    }
}