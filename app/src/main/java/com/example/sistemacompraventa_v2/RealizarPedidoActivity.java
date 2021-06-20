package com.example.sistemacompraventa_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sistemacompraventa_v2.entidades.Domicilio;
import com.example.sistemacompraventa_v2.entidades.Publicacion;
import com.example.sistemacompraventa_v2.entidades.Transaccion;
import com.example.sistemacompraventa_v2.sesionusuario.LoginSession;
import com.example.sistemacompraventa_v2.utilities.ApiRequests;

import java.util.ArrayList;
import java.util.List;

public class RealizarPedidoActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private TextView cantidadArticulos;
    private TextView subtotal;
    private Button mandarPedidoButton;
    private Spinner domiciliosSpinner;
    private Transaccion transaccion;
    private ApiRequests requests;
    private List< String > domicilios;
    private boolean realizoPedido;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.realizar_pedido_activity );

        realizoPedido = false;
        domicilios = new ArrayList<>();
        requests = new ApiRequests();
        cantidadArticulos = findViewById( R.id.cantidad_articulos_pedido );
        subtotal = findViewById( R.id.subtotal_articulos_pedido );
        mandarPedidoButton = findViewById( R.id.mandar_pedido_button );
        domiciliosSpinner = findViewById( R.id.spinner_pedidos );

        SetInformation();
        requests.getDomiciliosUsuarioPedido( this, LoginSession.getInstance().getClaveUsuario(), LoginSession.getInstance().getAccessToken() );
    }

    public void setSpinnerAdapter( List< Domicilio > domiciliosIn ) {
        for( int i = 0; i < domiciliosIn.size(); i++ ) {
            domicilios.add( domiciliosIn.get( i ).getCalle() + domiciliosIn.get( i ).getMunicipio() );
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter< String >( this, android.R.layout.simple_spinner_item, domicilios );
        dataAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        domiciliosSpinner.setAdapter( dataAdapter );
    }

    @Override
    public void onClick( View view ) {
        switch( view.getId() ) {
            case R.id.mandar_pedido_button:
                if( !realizoPedido ) {
                    realizoPedido = true;
                    requests.agregarTransaccion( getBaseContext(), LoginSession.getInstance().getClaveUsuario(), transaccion, LoginSession.getInstance().getAccessToken() );
                }
                break;
        }
    }

    @Override
    public void onItemSelected( AdapterView<?> parent, View view, int position, long id ) {
        transaccion = new Transaccion( 0, 1, parent.getItemAtPosition( position ).toString(),
                                        "2021/06/21", Double.parseDouble( subtotal.getText().toString() ), false,
                                        getPublicaciones() );
    }

    @Override
    public void onNothingSelected( AdapterView<?> parent ) {

    }

    private void SetInformation() {
        cantidadArticulos.setText( Integer.toString( LoginSession.getInstance().getArticulosCarrito().size() ) );
        subtotal.setText( Double.toString( getSubtotal() ) );
    }

    private Double getSubtotal() {
        double total = 0.0;
        for( int i = 0; i < LoginSession.getInstance().getArticulosCarrito().size(); i++ ) {
            total += LoginSession.getInstance().getArticulosCarrito().get( i ).getPrecio();
        }
        return total;
    }

    private List< Integer > getPublicaciones() {
        List< Integer > ids = new ArrayList<>();
        for( int i = 0; i < LoginSession.getInstance().getArticulosCarrito().size(); i++ ) {
            ids.add( LoginSession.getInstance().getArticulosCarrito().get( i ).getClave_publicacion() );
        }
        return ids;
    }
}