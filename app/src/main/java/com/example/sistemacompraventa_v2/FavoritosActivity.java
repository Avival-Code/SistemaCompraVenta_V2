package com.example.sistemacompraventa_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sistemacompraventa_v2.adaptadores.AdaptadorCarrito;
import com.example.sistemacompraventa_v2.adaptadores.AdaptadorFavorito;
import com.example.sistemacompraventa_v2.sesionusuario.LoginSession;
import com.example.sistemacompraventa_v2.utilities.ApiRequests;

public class FavoritosActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdaptadorFavorito adaptador;
    private ApiRequests requests;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.favoritos_activity );

        requests = new ApiRequests();
        recyclerView = findViewById( R.id.recyclerViewFavoritos );
        requests.getArticulosFavoritos( this, LoginSession.getInstance().getClaveUsuario(), LoginSession.getInstance().getAccessToken() );
    }

    @Override
    protected void onResume() {
        super.onResume();
        setArticulosCarrito();
    }

    public void setArticulosCarrito() {
        if( LoginSession.getInstance().getArticulosFavoritos() != null ) {
            adaptador = new AdaptadorFavorito( this );
            recyclerView.setAdapter( adaptador );
            recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
        } else {
            Toast.makeText( this, R.string.favoritos_no_encontrados, Toast.LENGTH_SHORT ).show();
        }
    }
}