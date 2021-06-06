package com.example.sistemacompraventa_v2.controladores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.sistemacompraventa_v2.R;

public class IniciarSesionFragmento extends Fragment implements View.OnClickListener {
    private Button iniciar_sesion_button;
    private Button register_button;

    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        View mainView = inflater.inflate( R.layout.iniciar_sesion_fragment,container, false );

        iniciar_sesion_button = ( Button )mainView.findViewById( R.id.iniciar_sesion_button );
        register_button = ( Button )mainView.findViewById( R.id.register_button );
        iniciar_sesion_button.setOnClickListener( this );
        register_button.setOnClickListener( this );

        return mainView;
    }

    @Override
    public void onClick( View view ) {
        switch( view.getId() )
        {
            case R.id.iniciar_sesion_button:
                break;

            case R.id.register_button:
                final FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace( R.id.Fragment_container, new RegistrarFragmento() ).commit();
                break;
        }
    }
}
