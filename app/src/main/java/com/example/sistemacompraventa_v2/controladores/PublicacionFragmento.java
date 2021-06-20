package com.example.sistemacompraventa_v2.controladores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sistemacompraventa_v2.R;

public class PublicacionFragmento extends Fragment{
    private View publicacionView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        publicacionView = inflater.inflate(R.layout.perfil_fragment, container, false);

        return publicacionView;
    }
}
