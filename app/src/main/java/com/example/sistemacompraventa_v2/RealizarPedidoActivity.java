package com.example.sistemacompraventa_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sistemacompraventa_v2.entidades.Transaccion;
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

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.realizar_pedido_activity );

        requests = new ApiRequests();
        cantidadArticulos = findViewById( R.id.cantidad_articulos_pedido );
        subtotal = findViewById( R.id.subtotal_articulos_pedido );
        mandarPedidoButton = findViewById( R.id.mandar_pedido_button );
        domiciliosSpinner = findViewById( R.id.spinner_pedidos );
    }

    private void setSpinnerAdapter() {

        //ArrayAdapter<String> dataAdapter = new ArrayAdapter< String >( this, android.R.layout.simple_spinner_item, calificaciones );
        //dataAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        //domiciliosSpinner.setAdapter( dataAdapter );
    }

    @Override
    public void onClick( View view ) {
        switch( view.getId() ) {
            case R.id.mandar_pedido_button:
                break;
        }
    }

    @Override
    public void onItemSelected( AdapterView<?> parent, View view, int position, long id ) {
        transaccion = new Transaccion();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}