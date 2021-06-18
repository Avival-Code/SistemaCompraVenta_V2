package com.example.sistemacompraventa_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sistemacompraventa_v2.adaptadores.AdaptadorTransaccion;
import com.example.sistemacompraventa_v2.sesionusuario.LoginSession;
import com.example.sistemacompraventa_v2.utilities.ApiRequests;

public class RevisarHistorialActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdaptadorTransaccion adaptador;
    private ApiRequests requests;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.revisar_historial_activity );

        requests = new ApiRequests();
        recyclerView = findViewById( R.id.recyclerViewHistorial );
        requests.getTransaccionesUsuario( this, LoginSession.getInstance().getClaveUsuario(), LoginSession.getInstance().getAccessToken() );
    }

    public void setTransaccionesHistorial() {
        adaptador = new AdaptadorTransaccion( this );
        recyclerView.setAdapter( adaptador );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
    }
}