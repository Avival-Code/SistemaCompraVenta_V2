package com.example.sistemacompraventa_v2.controladores;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.sistemacompraventa_v2.CrearPublicacionActivity;
import com.example.sistemacompraventa_v2.R;

public class PublicacionFragmento extends Fragment implements View.OnClickListener{
    private View publicacionView;
    private Button crearPublicacion;
    private Button verPublicaciones;

    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        publicacionView = inflater.inflate(R.layout.publicacion_fragment, container, false);

        crearPublicacion = publicacionView.findViewById( R.id.crear_publicacion_button );
        verPublicaciones = publicacionView.findViewById( R.id.ver_publicaciones_button );
        crearPublicacion.setOnClickListener( this );
        verPublicaciones.setOnClickListener( this );

        return publicacionView;
    }

    @Override
    public void onClick( View view ) {
        switch( view.getId() ) {
            case R.id.crear_publicacion_button:
                Intent crearPublicacionIntent = new Intent( getActivity(), CrearPublicacionActivity.class );
                getActivity().startActivity( crearPublicacionIntent );
                break;

            case R.id.ver_publicaciones_button:
                final FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace( R.id.Fragment_container, new ListaPublicacionesFragmento() ).commit();
                break;
        }
    }
}
