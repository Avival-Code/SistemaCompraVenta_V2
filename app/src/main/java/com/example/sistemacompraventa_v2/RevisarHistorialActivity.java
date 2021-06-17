package com.example.sistemacompraventa_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sistemacompraventa_v2.adaptadores.AdaptadorCarrito;
import com.example.sistemacompraventa_v2.adaptadores.AdaptadorTransacciones;

public class RevisarHistorialActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdaptadorTransacciones adaptador;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.revisar_historial_activity );

        recyclerView = findViewById( R.id.recyclerViewHistorial );
        setTransaccionesHistorial();
    }

    public void setTransaccionesHistorial() {
        adaptador = new AdaptadorTransacciones( this );
        recyclerView.setAdapter( adaptador );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
    }
}