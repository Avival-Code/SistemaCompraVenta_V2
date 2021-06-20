package com.example.sistemacompraventa_v2.controladores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sistemacompraventa_v2.R;

public class PublicacionFragmento extends Fragment implements View.OnClickListener{
    private View publicacionView;
    private Button crearPublicacion;
    private Button verPublicaciones;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        publicacionView = inflater.inflate(R.layout.perfil_fragment, container, false);

        crearPublicacion = publicacionView.findViewById( R.id.crear_publicacion_button );
        verPublicaciones = publicacionView.findViewById( R.id.ver_publicaciones_button );

        return publicacionView;
    }

    @Override
    public void onClick( View view ) {
        switch( view.getId() ) {
            case R.id.crear_publicacion_button:
                break;

            case R.id.ver_publicaciones_button:
                break;
        }
    }
}
