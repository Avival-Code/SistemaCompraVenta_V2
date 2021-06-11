package com.example.sistemacompraventa_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.sistemacompraventa_v2.adaptadores.AdaptadorBuscar;
import com.example.sistemacompraventa_v2.entidades.Publicacion;
import com.example.sistemacompraventa_v2.utilities.ApiRequests;

import java.util.ArrayList;
import java.util.List;

public class BuscarActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List< Publicacion > publicaciones;
    private ApiRequests requests;
    private AdaptadorBuscar adaptador;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_buscar );

        publicaciones = new ArrayList<>();
        requests = new ApiRequests();
        requests.getPublicacionesBuscar( this );
        recyclerView = findViewById( R.id.recyclerView );
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        getMenuInflater().inflate( R.menu.buscar_menu, menu );
        MenuItem menuItem = menu.findItem( R.id.search_menu );
        SearchView searchView = ( SearchView ) menuItem.getActionView();

        searchView.setOnQueryTextListener( new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit( String query ) {
                return false;
            }

            @Override
            public boolean onQueryTextChange( String newText ) {
                adaptador.getFilter().filter( newText );
                return false;
            }
        });
        return super.onCreateOptionsMenu( menu );
    }

    public void setPublicaciones( List< Publicacion > publicacionesIn ) {
        publicaciones = publicacionesIn;
        adaptador = new AdaptadorBuscar( this, publicaciones );
        recyclerView.setAdapter( adaptador );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
    }
}