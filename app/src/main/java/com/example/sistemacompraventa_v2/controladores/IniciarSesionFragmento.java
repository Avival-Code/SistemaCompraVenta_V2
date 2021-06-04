package com.example.sistemacompraventa_v2.controladores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sistemacompraventa_v2.R;

public class IniciarSesionFragmento extends Fragment {
    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        return inflater.inflate( R.layout.iniciar_sesion_fragment,container, false );
    }
}
