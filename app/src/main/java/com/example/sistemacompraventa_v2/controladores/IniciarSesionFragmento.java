package com.example.sistemacompraventa_v2.controladores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.sistemacompraventa_v2.MainActivity;
import com.example.sistemacompraventa_v2.R;
import com.example.sistemacompraventa_v2.sesionusuario.LoginSession;
import com.example.sistemacompraventa_v2.utilities.ApiRequests;
import com.example.sistemacompraventa_v2.utilities.StringValidator;

public class IniciarSesionFragmento extends Fragment implements View.OnClickListener {
    private View inicioSesionView;
    private Button iniciar_sesion_button;
    private Button register_button;
    private StringValidator validator;
    private ApiRequests requests;

    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        inicioSesionView = inflater.inflate( R.layout.iniciar_sesion_fragment, container, false );

        validator = new StringValidator();
        requests = new ApiRequests();
        iniciar_sesion_button = ( Button )inicioSesionView.findViewById( R.id.iniciar_sesion_button );
        register_button = ( Button )inicioSesionView.findViewById( R.id.register_fragment_button );
        iniciar_sesion_button.setOnClickListener( this );
        register_button.setOnClickListener( this );

        return inicioSesionView;
    }

    @Override
    public void onClick( View view ) {
        switch( view.getId() )
        {
            case R.id.iniciar_sesion_button:
                checkLoginInput();
                isLoggedIn();
                if( validator.IsLoginInformationValid( ( ( EditText )inicioSesionView.findViewById( R.id.inicio_usuario_field ) ).getText().toString(),
                                                       ( ( EditText )inicioSesionView.findViewById( R.id.inicio_contrasena_field ) ).getText().toString() ) &&
                    !LoginSession.GetInstance().IsLoggedIn() ) {
                    requests.Login( getActivity(), ( ( EditText )inicioSesionView.findViewById( R.id.inicio_usuario_field ) ).getText().toString(),
                                    ( ( EditText )inicioSesionView.findViewById( R.id.inicio_contrasena_field ) ).getText().toString() );
                }
                break;

            case R.id.register_fragment_button:
                final FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace( R.id.Fragment_container, new RegistrarFragmento() ).commit();
                break;
        }
    }

    private void checkLoginInput() {
        checkUsername();
        checkPassword();
    }

    private void checkUsername() {
        if( !validator.IsUsernameValid( ( ( EditText )inicioSesionView.findViewById( R.id.inicio_usuario_field ) ).getText().toString() ) ) {
            Toast.makeText( getContext(), R.string.usuario_invalido, Toast.LENGTH_SHORT ).show();
        }
    }

    private void checkPassword() {
        if( !validator.IsPasswordValid( ( ( EditText )inicioSesionView.findViewById( R.id.inicio_contrasena_field ) ).getText().toString() ) ) {
            Toast.makeText( getContext(), R.string.contrasena_invalida, Toast.LENGTH_SHORT ).show();
        }
    }

    private void isLoggedIn() {
        if( LoginSession.GetInstance().IsLoggedIn() ) {
            Toast.makeText( getContext(), R.string.sesion_iniciada, Toast.LENGTH_SHORT ).show();
        }
    }
}
