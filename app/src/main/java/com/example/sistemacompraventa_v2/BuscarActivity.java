package com.example.sistemacompraventa_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.sistemacompraventa_v2.adaptadores.AdaptadorBuscar;
import com.example.sistemacompraventa_v2.entidades.Publicacion;

import java.util.ArrayList;
import java.util.List;

public class BuscarActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List< Publicacion > publicaciones;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_buscar );

        publicaciones = new ArrayList<>();
        recyclerView = findViewById( R.id.recyclerView );

        AdaptadorBuscar adaptador = new AdaptadorBuscar( this, publicaciones );
        recyclerView.setAdapter( adaptador );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate( R.menu.buscar_menu, menu );
        MenuItem menuItem = menu.findItem( R.id.buscar_menu );
        SearchView searchView = ( SearchView ) MenuItemCompat.getActionView( menuItem );

        searchView.setOnQueryTextListener( new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit( String query ) {
                return false;
            }

            @Override
            public boolean onQueryTextChange( String newText ) {
                return false;
            }
        });
        return super.onCreateOptionsMenu( menu );
    }
}