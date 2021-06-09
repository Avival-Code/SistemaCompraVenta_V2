package com.example.sistemacompraventa_v2.controladores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.sistemacompraventa_v2.R;
import com.example.sistemacompraventa_v2.entidades.Usuario;
import com.example.sistemacompraventa_v2.sesionusuario.LoginSession;
import com.example.sistemacompraventa_v2.utilities.StringValidator;

public class ModificarDatosFragmento extends Fragment implements View.OnClickListener {
    private View modificarDatosView;
    private Button modificarDatosButton;
    private Button cancelarButton;
    private StringValidator validator;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        modificarDatosView = inflater.inflate( R.layout.modificar_datos_fragment, container, false );

        validator = new StringValidator();
        modificarDatosButton = ( Button )modificarDatosView.findViewById( R.id.modificar_datos_personales_button );
        cancelarButton = ( Button )modificarDatosView.findViewById( R.id.modificar_cancel_button );
        modificarDatosButton.setOnClickListener( this );
        cancelarButton.setOnClickListener( this );

        return modificarDatosView;
    }

    @Override
    public void onClick( View view ) {
        switch( view.getId() ) {
            case R.id.modificar_datos_personales_button:
                checkUserInput();
                if( validator.isUserUpdateInformationValid( createUser() ) ) {
                    
                }
                break;

            case R.id.modificar_cancel_button:
                showPerfilScreen();
                break;
        }
    }

    private void showPerfilScreen() {
        final FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace( R.id.Fragment_container, new PerfilFragmento() ).commit();
    }

    private void checkUserInput() {
        checkNames();
        checkLastNames();
        checkPhone();
        checkEmail();
    }

    private void checkNames() {
        if( !validator.AreNamesValid( ( (EditText)modificarDatosView.findViewById( R.id.modificar_nombres_text ) ).getText().toString() ) ) {
            Toast.makeText( getContext(), R.string.nombres_invalidos, Toast.LENGTH_SHORT ).show();
        }
    }

    private void checkLastNames() {
        if( !validator.AreLastNamesValid( ( ( EditText )modificarDatosView.findViewById( R.id.modificar_apellidos_text ) ).getText().toString() ) ) {
            Toast.makeText( getContext(), R.string.apellidos_invalidos, Toast.LENGTH_SHORT ).show();
        }
    }

    private void checkPhone() {
        if( !validator.IsTelephoneValid( ( ( EditText )modificarDatosView.findViewById( R.id.modificar_telefono_text ) ).getText().toString() ) ) {
            Toast.makeText( getContext(), R.string.telefono_invalido, Toast.LENGTH_SHORT ).show();
        }
    }

    private void checkEmail() {
        if( !validator.IsEmailValid( ( ( EditText )modificarDatosView.findViewById( R.id.modificar_correo_text ) ).getText().toString() ) ) {
            Toast.makeText( getContext(), R.string.correo_invalido, Toast.LENGTH_SHORT ).show();
        }
    }

    private Usuario createUser() {
        return new Usuario( LoginSession.getInstance().getClaveUsuario(), ( (EditText)modificarDatosView.findViewById( R.id.modificar_nombres_text ) ).getText().toString(),
                ( ( EditText )modificarDatosView.findViewById( R.id.modificar_apellidos_text ) ).getText().toString(),
                ( ( EditText )modificarDatosView.findViewById( R.id.modificar_correo_text ) ).getText().toString(),
                ( ( EditText )modificarDatosView.findViewById( R.id.modificar_telefono_text ) ).getText().toString(), LoginSession.getInstance().getUsuario().getUsuario(),
                LoginSession.getInstance().getUsuario().getContrasena(), LoginSession.getInstance().getUsuario().getCalificacion(), LoginSession.getInstance().getUsuario().getTipoUsuario() );
    }
}
