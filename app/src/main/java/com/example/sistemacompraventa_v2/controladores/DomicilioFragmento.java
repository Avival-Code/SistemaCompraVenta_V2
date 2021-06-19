package com.example.sistemacompraventa_v2.controladores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistemacompraventa_v2.R;
import com.example.sistemacompraventa_v2.adaptadores.AdaptadorDomicilio;
import com.example.sistemacompraventa_v2.entidades.Domicilio;
import com.example.sistemacompraventa_v2.utilities.ApiRequests;

import java.util.List;

public class DomicilioFragmento extends Fragment {
    private List<Domicilio> domicilios;
    private RecyclerView recyclerView;
    private ApiRequests requests;
    private AdaptadorDomicilio adaptador;
    private View domiciliosView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        domiciliosView = inflater.inflate( R.layout.domicilios_fragment, container, false );

        return domiciliosView;
    }
}
