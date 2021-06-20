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
import com.example.sistemacompraventa_v2.entidades.Domicilio;
import com.example.sistemacompraventa_v2.sesionusuario.LoginSession;
import com.example.sistemacompraventa_v2.utilities.ApiRequests;

import java.util.ArrayList;
import java.util.List;

public class DomicilioFragmento extends Fragment {
    private List<Domicilio> domicilios;
    private RecyclerView recyclerView;
    private ApiRequests requests;
    private AdaptadorDomicilio adaptador;
    private View domiciliosView;

    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        domiciliosView = inflater.inflate( R.layout.domicilios_fragment, container, false );

        domicilios = new ArrayList<>();
        requests = new ApiRequests();
        recyclerView = domiciliosView.findViewById( R.id.recyclerViewDomicilios );
        requests.getDomiciliosUsuario( this, getContext(), LoginSession.getInstance().getClaveUsuario(), LoginSession.getInstance().getAccessToken() );
        return domiciliosView;
    }

    public void SetDomicilios( List< Domicilio > domiciliosIn ) {
        domicilios = domiciliosIn;
        adaptador = new AdaptadorDomicilio( getContext(), domicilios );
        recyclerView.setAdapter( adaptador );
        recyclerView.setLayoutManager( new LinearLayoutManager( getContext() ) );
    }
}
