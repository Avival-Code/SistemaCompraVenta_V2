package com.example.sistemacompraventa_v2.controladores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sistemacompraventa_v2.R;
import com.example.sistemacompraventa_v2.utilities.ApiRequests;
import com.example.sistemacompraventa_v2.entidades.Usuario;
import com.example.sistemacompraventa_v2.enumeraciones.TipoUsuario;

public class RegistrarFragmento extends Fragment implements View.OnClickListener {
    private Button register_Button;
    private ApiRequests requests;
    private View registerView;

    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        registerView = inflater.inflate( R.layout.register_fragment, container, false );
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
                requests.RegisterUser( getActivity().getBaseContext(), createUser() );
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
}
