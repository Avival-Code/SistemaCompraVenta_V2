package com.example.sistemacompraventa_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sistemacompraventa_v2.entidades.Publicacion;
import com.example.sistemacompraventa_v2.enumeraciones.Categoria;
import com.example.sistemacompraventa_v2.sesionusuario.LoginSession;
import com.example.sistemacompraventa_v2.utilities.ApiRequests;

public class VisualizarArticuloCarrito extends AppCompatActivity implements View.OnClickListener {
    private ApiRequests requests;
    private TextView titulo;
    private TextView descripcion;
    private TextView precio;
    private TextView calificacion;
    private TextView cantidad;
    private ImageView imagen;
    private Button eliminarArticuloButton;
    private Publicacion publicacion;
    private boolean eliminado;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.visualizar_articulo_carrito_activity );

        eliminado = false;
        requests = new ApiRequests();
        titulo = findViewById( R.id.titulo_carrito );
        descripcion = findViewById( R.id.descripcion_carrito );
        precio = findViewById( R.id.precio_carrito );
        calificacion = findViewById( R.id.calificacion_carrito );
        cantidad = findViewById( R.id.cantidadDisponible_carrito );
        imagen = findViewById( R.id.imagenCarritoPublicacion );
        eliminarArticuloButton = findViewById( R.id.eliminar_carrito_button );

        eliminarArticuloButton.setOnClickListener( this );

        getData();
        setData();
    }

    @Override
    public void onClick( View view ) {
        switch( view.getId() ) {
            case R.id.eliminar_carrito_button:
                if( !eliminado ) {
                    eliminado = true;
                    requests.eliminarArticuloCarrito( getBaseContext(), LoginSession.getInstance().getClaveUsuario(),
                            publicacion.getClave_publicacion(), LoginSession.getInstance().getAccessToken() );
                    LoginSession.getInstance().eliminarArticuloCarrito( publicacion.getClave_publicacion() );
                }
                break;
        }
    }

    private void getData() {
        if( getIntent().hasExtra( "clave_publicacion" ) && getIntent().hasExtra( "nombre" ) &&
                getIntent().hasExtra( "descripcion") && getIntent().hasExtra( "categoria" ) &&
                getIntent().hasExtra( "precio" ) && getIntent().hasExtra( "cantidad_disponible" ) &&
                getIntent().hasExtra( "calificacion" ) && getIntent().hasExtra( "unidad_medida" ) &&
                getIntent().hasExtra( "numero_ventas" ) && getIntent().hasExtra( "imagen" ) ) {
            publicacion = new Publicacion( getIntent().getIntExtra( "clave_publicacion", 1 ), getIntent().getStringExtra( "nombre" ),
                    getIntent().getStringExtra( "descripcion" ), Categoria.values()[ getIntent().getIntExtra( "categoria", 1 ) ],
                    getIntent().getDoubleExtra( "precio", 0.0 ), getIntent().getIntExtra( "cantidad", 1 ),
                    getIntent().getDoubleExtra( "calificacion", 0.0 ), getIntent().getStringExtra( "unidad_medida" ),
                    getIntent().getIntExtra( "numero_ventas", 1 ), getIntent().getStringExtra( "imagen" ) );
        } else {
            Toast.makeText( this, R.string.no_hay_datos, Toast.LENGTH_SHORT ).show();
        }
    }

    private void setData() {
        titulo.setText( publicacion.getNombre() );
        descripcion.setText( publicacion.getDescripcion() );
        precio.setText( Double.toString( publicacion.getPrecio() ) );
        calificacion.setText( Double.toString( publicacion.getCalificacion_general() ) );
        cantidad.setText( Integer.toString( publicacion.getCantidad_disponible() ) );
    }
}