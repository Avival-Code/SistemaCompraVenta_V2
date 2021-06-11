package com.example.sistemacompraventa_v2.controladores;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.sistemacompraventa_v2.R;
import com.example.sistemacompraventa_v2.sesionusuario.LoginSession;
import com.example.sistemacompraventa_v2.utilities.ApiRequests;

public class CarritoFragmento extends Fragment implements View.OnClickListener{
    private View carritoView;
    private TextView cantidadText;
    private TextView subtotalText;
    private Button realizarPedidoButton;
    private Button verArticulosButton;
    private ApiRequests requests;

    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        carritoView = inflater.inflate( R.layout.carrito_fragment, container, false );

        requests = new ApiRequests();
        requests.getArticulosCarrito( getActivity().getBaseContext(), LoginSession.getInstance().getClaveUsuario(), LoginSession.getInstance().getAccessToken() );
        cantidadText = carritoView.findViewById( R.id.numero_articulos_carrito );
        subtotalText = carritoView.findViewById( R.id.subtotal_carrito );
        realizarPedidoButton = carritoView.findViewById( R.id.realizarPedidoButton );
        verArticulosButton = carritoView.findViewById( R.id.verArticulosButton );

        realizarPedidoButton.setOnClickListener( this );
        verArticulosButton.setOnClickListener( this );
        return carritoView;
    }


    @Override
    public void onClick( View view ) {
        switch( view.getId() ) {
            case R.id.realizarPedidoButton:
                break;

            case R.id.verArticulosButton:
                break;
        }
    }
}