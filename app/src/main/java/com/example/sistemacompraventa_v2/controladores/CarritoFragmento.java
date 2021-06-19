package com.example.sistemacompraventa_v2.controladores;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sistemacompraventa_v2.CarritoArticulosActivity;
import com.example.sistemacompraventa_v2.R;
import com.example.sistemacompraventa_v2.RealizarPedidoActivity;
import com.example.sistemacompraventa_v2.entidades.Publicacion;
import com.example.sistemacompraventa_v2.sesionusuario.LoginSession;
import com.example.sistemacompraventa_v2.utilities.ApiRequests;

import java.util.List;

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
        requests.getArticulosCarrito( this, getActivity().getBaseContext(), LoginSession.getInstance().getClaveUsuario(), LoginSession.getInstance().getAccessToken() );
        cantidadText = carritoView.findViewById( R.id.numero_articulos_carrito );
        subtotalText = carritoView.findViewById( R.id.subtotal_carrito );
        realizarPedidoButton = carritoView.findViewById( R.id.realizarPedidoButton );
        verArticulosButton = carritoView.findViewById( R.id.verArticulosButton );

        realizarPedidoButton.setOnClickListener( this );
        verArticulosButton.setOnClickListener( this );
        return carritoView;
    }

    @Override
    public void onResume() {
        super.onResume();
        setData();
    }


    @Override
    public void onClick( View view ) {
        switch( view.getId() ) {
            case R.id.verArticulosButton:
                Intent intent = new Intent( getActivity(), CarritoArticulosActivity.class );
                getActivity().startActivity( intent );
                break;

            case R.id.realizarPedidoButton:
                if( LoginSession.getInstance().getArticulosCarrito().size() > 0 ) {
                    Intent pedidoIntent = new Intent( getActivity(), RealizarPedidoActivity.class );
                    getActivity().startActivity( pedidoIntent );
                } else {
                    Toast.makeText( getContext(), R.string.carrito_vacio, Toast.LENGTH_SHORT ).show();
                }
                break;
        }
    }

    public void setData() {
        cantidadText.setText( Integer.toString( LoginSession.getInstance().getArticulosCarrito().size() ) );
        subtotalText.setText( Double.toString( getSubtotal( LoginSession.getInstance().getArticulosCarrito() ) ) );
    }

    private double getSubtotal( List< Publicacion > articulos ) {
        double subtotal = 0.0;
        for( int current = 0; current < articulos.size(); current++ ) {
            subtotal += articulos.get( current ).getPrecio();
        }
        return subtotal;
    }
}