package com.example.sistemacompraventa_v2.controladores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.sistemacompraventa_v2.R;

public class ModificarDatosFragmento extends Fragment implements View.OnClickListener {
    private View modificarDatosView;
    private Button modificarDatosButton;
    private Button cancelarButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        modificarDatosView = inflater.inflate( R.layout.modificar_datos_fragment, container, false );

        modificarDatosButton = ( Button )modificarDatosView.findViewById( R.id.modificar_datos_personales_button );
        cancelarButton = ( Button )modificarDatosView.findViewById( R.id.modificar_cancel_button );
        modificarDatosButton.setOnClickListener( this );
        cancelarButton.setOnClickListener( this );

        return modificarDatosView;
    }

    @Override
    public void onClick( View view ) {
        switch( view.getId() ) {
            case R.id.modificar_cancel_button:
                showPerfilScreen();
                break;

            case R.id.modificar_datos_personales_button:
                break;
        }
    }

    private void showPerfilScreen() {
        final FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace( R.id.Fragment_container, new PerfilFragmento() ).commit();
    }
}
