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
    public void onBindViewHolder( @NonNull @NotNull AdaptadorDomicilio.MyViewHolder holder, int position ) {
        holder.calle.setText( domicilios.get( position ).getCalle() );
        holder.colonia.setText( domicilios.get( position ).getColonia() );

        holder.mainLayout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
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
