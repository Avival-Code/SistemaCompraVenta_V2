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

public class DetallesPublicacionActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView titulo;
    private TextView descripcion;
    private TextView precio;
    private TextView calificacion;
    private TextView cantidad;
    private ImageView imagen;
    private Button carritoButton;
    private Button favoritosButton;
    private Publicacion publicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.detalles_activity );

        titulo = findViewById( R.id.titulo_detalles );
        descripcion = findViewById( R.id.descripcion_detalles );
        precio = findViewById( R.id.precio_detalles );
        calificacion = findViewById( R.id.calificacion_detalles );
        cantidad = findViewById( R.id.cantidadDisponible_detalles );
        imagen = findViewById( R.id.imagenDetallesPublicacion );
        carritoButton = findViewById( R.id.agregarCarritoButton );
        favoritosButton = findViewById( R.id.agregarFavoritosButton );

        carritoButton.setOnClickListener( this );
        favoritosButton.setOnClickListener( this );

        getData();
        setData();
    }

    @Override
    public void onClick( View view ) {
        switch( view.getId() ) {
            case R.id.agregarCarritoButton:
                break;

            case R.id.agregarFavoritosButton:
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