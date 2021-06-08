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

import com.example.sistemacompraventa_v2.R;
import com.example.sistemacompraventa_v2.utilities.ApiRequests;
import com.example.sistemacompraventa_v2.entidades.Usuario;
import com.example.sistemacompraventa_v2.enumeraciones.TipoUsuario;
import com.example.sistemacompraventa_v2.utilities.StringValidator;

public class RegistrarFragmento extends Fragment implements View.OnClickListener {
    private Button register_Button;
    private ApiRequests requests;
    private View registerView;
    private StringValidator validator;

    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        registerView = inflater.inflate( R.layout.register_fragment, container, false );
        validator = new StringValidator();
        register_Button = ( Button ) registerView.findViewById( R.id.register_button );
        register_Button.setOnClickListener( this );
        requests = new ApiRequests();

        return registerView;
    }

    @Override
    public void onClick( View view ) {
        switch( view.getId() )
        {
            case R.id.register_button:
                checkUserInput();
                if( validator.IsUsuarioInformationValid( createUser(), ( ( EditText )registerView.findViewById( R.id.confirmar_contrasena_field ) ).getText().toString() ) ) {
                    requests.RegisterUser( getActivity().getBaseContext(), createUser() );
                }
                break;
        }
    }

    private Usuario createUser() {
        return new Usuario( 0, ( ( EditText )registerView.findViewById( R.id.nombres_field ) ).getText().toString(),
                               ( ( EditText )registerView.findViewById( R.id.apellidos_field ) ).getText().toString(),
                               ( ( EditText )registerView.findViewById( R.id.correo_field ) ).getText().toString(),
                               ( ( EditText )registerView.findViewById( R.id.telefono_field ) ).getText().toString(),
                               ( ( EditText )registerView.findViewById( R.id.usuario_field ) ).getText().toString(),
                               ( ( EditText )registerView.findViewById( R.id.contrasena_field ) ).getText().toString(),
                             0.0f, TipoUsuario.comprador );
    }

    private void checkUserInput() {
        checkNames();
        checkLastNames();
        checkPhone();
        checkUsername();
        checkPassword();
        doPasswordsMatch();
    }

    private void checkNames() {
        if( !validator.AreNamesValid( ( ( EditText )registerView.findViewById( R.id.nombres_field ) ).getText().toString() ) ) {
            Toast.makeText( getContext(), R.string.nombres_invalidos, Toast.LENGTH_SHORT ).show();
        }
    }

    private void checkLastNames() {
        if( !validator.AreLastNamesValid( ( ( EditText )registerView.findViewById( R.id.apellidos_field ) ).getText().toString() ) ) {
            Toast.makeText( getContext(), R.string.apellidos_invalidos, Toast.LENGTH_SHORT ).show();
        }
    }

    private void checkPhone() {
        if( !validator.IsTelephoneValid( ( ( EditText )registerView.findViewById( R.id.telefono_field ) ).getText().toString() ) ) {
            Toast.makeText( getContext(), R.string.telefono_invalido, Toast.LENGTH_SHORT ).show();
        }
    }

    private void checkUsername() {
        if( !validator.IsUsernameValid( ( ( EditText )registerView.findViewById( R.id.usuario_field ) ).getText().toString() ) ) {
            Toast.makeText( getContext(), R.string.usuario_invalido, Toast.LENGTH_SHORT ).show();
        }
    }

    private void checkPassword() {
        if( !validator.IsPasswordValid( ( ( EditText )registerView.findViewById( R.id.contrasena_field ) ).getText().toString() ) ) {
            Toast.makeText( getContext(), R.string.contrasena_invalida, Toast.LENGTH_SHORT ).show();
        }
    }

    private void doPasswordsMatch() {
        if( !validator.DoPasswordsMatch( ( ( EditText )registerView.findViewById( R.id.contrasena_field ) ).getText().toString(),
                                         ( ( EditText )registerView.findViewById( R.id.confirmar_contrasena_field ) ).getText().toString() ) ) {
            Toast.makeText( getContext(), R.string.contrasenas_no_coinciden, Toast.LENGTH_SHORT ).show();
        }
    }
}
