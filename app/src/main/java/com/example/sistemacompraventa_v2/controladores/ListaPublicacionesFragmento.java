package com.example.sistemacompraventa_v2.controladores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistemacompraventa_v2.R;
import com.example.sistemacompraventa_v2.adaptadores.AdaptadorDomicilio;
import com.example.sistemacompraventa_v2.adaptadores.AdaptadorPublicacion;
import com.example.sistemacompraventa_v2.entidades.Publicacion;
import com.example.sistemacompraventa_v2.utilities.ApiRequests;

import java.util.List;

public class ListaPublicacionesFragmento extends Fragment {
    private List<Publicacion> publicaciones;
    private RecyclerView recyclerView;
    private ApiRequests requests;
    private AdaptadorPublicacion adaptador;
    private View listaPublcacionesView;

    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        listaPublcacionesView = inflater.inflate( R.layout.lista_publicacion_fragment, container, false );

        requests = new ApiRequests();
        recyclerView = listaPublcacionesView.findViewById( R.id.recyclerViewListaPublicacion );
        return listaPublcacionesView;
    }

    public void SetPublicaciones( List< Publicacion > publicacionesIn ) {
        publicaciones = publicacionesIn;
        adaptador = new AdaptadorPublicacion( getContext(), publicaciones );
        recyclerView.setAdapter( adaptador );
        recyclerView.setLayoutManager( new LinearLayoutManager( getContext() ) );
    }
}
