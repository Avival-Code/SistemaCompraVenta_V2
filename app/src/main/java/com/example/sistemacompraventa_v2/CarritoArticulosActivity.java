package com.example.sistemacompraventa_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sistemacompraventa_v2.adaptadores.AdaptadorCarrito;

public class CarritoArticulosActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdaptadorCarrito adaptador;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.articulos_carrito_activity );

        recyclerView = findViewById( R.id.recyclerViewCarrito );
        setArticulosCarrito();
    }

    public void setArticulosCarrito() {
        adaptador = new AdaptadorCarrito( this );
        recyclerView.setAdapter( adaptador );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
    }
}