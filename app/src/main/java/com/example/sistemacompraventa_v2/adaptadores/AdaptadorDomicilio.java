package com.example.sistemacompraventa_v2.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistemacompraventa_v2.R;
import com.example.sistemacompraventa_v2.VisualizarArticuloCarrito;
import com.example.sistemacompraventa_v2.VisualizarDomicilioActivity;
import com.example.sistemacompraventa_v2.entidades.Domicilio;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdaptadorDomicilio extends RecyclerView.Adapter< AdaptadorDomicilio.MyViewHolder >{
    private Context viewContext;
    private List< Domicilio > domicilios;

    public AdaptadorDomicilio( Context contextIn, List< Domicilio > domiciliosIn ) {
        viewContext = contextIn;
        domicilios = domiciliosIn;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder( @NonNull @NotNull ViewGroup parent, int viewType ) {
        LayoutInflater inflater = LayoutInflater.from( viewContext );
        View view = inflater.inflate( R.layout.domicilio_card_row, parent, false );
        return new AdaptadorDomicilio.MyViewHolder( view );
    }

    @Override
    public void onBindViewHolder( @NonNull @NotNull AdaptadorDomicilio.MyViewHolder holder, final int position ) {
        holder.calle.setText( domicilios.get( position ).getCalle() );
        holder.colonia.setText( domicilios.get( position ).getColonia() );

        holder.mainLayout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent intent = new Intent( viewContext, VisualizarDomicilioActivity.class );
                intent.putExtra( "discriminante_domicilio", domicilios.get( position ).getDiscriminante() );
                intent.putExtra( "clave_usuario", domicilios.get( position ).getClaveUsuario() );
                intent.putExtra( "calle", domicilios.get( position ).getCalle() );
                intent.putExtra( "colonia", domicilios.get( position ).getCalle() );
                intent.putExtra( "municipio", domicilios.get( position ).getMunicipio() );
                intent.putExtra( "codigo_postal", domicilios.get( position ).getCodigo() );
                intent.putExtra( "estado", domicilios.get( position ).getEstado() );
                intent.putExtra( "numero_interno", domicilios.get( position ).getNumerInterno() );
                intent.putExtra( "numero_externo", domicilios.get( position ).getNumeroExterno() );
                intent.putExtra( "descripcion", domicilios.get( position ).getDescripcion() );
                viewContext.startActivity( intent );
            }
        } );
    }

    @Override
    public int getItemCount() { return domicilios.size(); }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView calle;
        TextView colonia;
        ConstraintLayout mainLayout;

        public MyViewHolder( @NonNull View itemView ) {
            super( itemView );
            calle = itemView.findViewById( R.id.calle_domicilio );
            colonia = itemView.findViewById( R.id.colonia_domicilio );
            mainLayout = itemView.findViewById( R.id.domicilioCardLayout );
        }
    }
}
