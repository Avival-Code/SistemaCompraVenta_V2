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
import com.example.sistemacompraventa_v2.sesionusuario.LoginSession;
import com.example.sistemacompraventa_v2.utilities.ApiRequests;

import java.security.Principal;

public class PerfilFragmento extends Fragment implements View.OnClickListener{
    private View perfilView;
    private TextView nombres;
    private TextView apellidos;
    private TextView correo;
    private TextView telefono;
    private Button modificarDatos;
    private Button agregarDomicilio;
    private Button eliminarCuenta;
    private ApiRequests requests;

    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        perfilView = inflater.inflate( R.layout.perfil_fragment, container, false );

        requests = new ApiRequests();
        modificarDatos = ( Button )perfilView.findViewById( R.id.modificar_datos_button );
        agregarDomicilio = ( Button )perfilView.findViewById( R.id.agregar_domicilio_button );
        eliminarCuenta = ( Button )perfilView.findViewById( R.id.eliminar_cuenta_button );
        nombres = ( TextView ) perfilView.findViewById( R.id.usuario_nombres_text );
        apellidos = ( TextView ) perfilView.findViewById( R.id.usuario_apellidos_text );
        correo = ( TextView ) perfilView.findViewById( R.id.usuario_correo_text );
        telefono = ( TextView ) perfilView.findViewById( R.id.usuario_telefono_text );
        modificarDatos.setOnClickListener( this );
        agregarDomicilio.setOnClickListener( this );
        eliminarCuenta.setOnClickListener( this );
        loadUserInfo();

        return perfilView;
    }

    @Override
    public void onClick( View view ) {
        switch( view.getId() ) {
            case R.id.modificar_datos_button:
                showModifyInfoScreen();
                break;

            case R.id.agregar_domicilio_button:
                showAddAddressScreen();
                break;

            case R.id.eliminar_cuenta_button:
                requests.eliminarUsuario( getActivity(), LoginSession.getInstance().getClaveUsuario(), LoginSession.getInstance().getAccessToken() );
                showMainScreen();
                break;
        }
    }

    private void showModifyInfoScreen() {
        final FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace( R.id.Fragment_container, new ModificarDatosFragmento() ).commit();
    }

    private void showAddAddressScreen() {

    }

    private void showMainScreen() {
        final FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace( R.id.Fragment_container, new PrincipalFragmento() ).commit();
    }

    private void loadUserInfo() {
        nombres.setText( LoginSession.getInstance().getUsuario().getNombres() );
        apellidos.setText( LoginSession.getInstance().getUsuario().getApellidos() );
        correo.setText( LoginSession.getInstance().getUsuario().getCorreoElectronico() );
        telefono.setText( LoginSession.getInstance().getUsuario().getTelefono() );
    }
}
