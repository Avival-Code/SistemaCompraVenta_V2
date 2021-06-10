package com.example.sistemacompraventa_v2.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistemacompraventa_v2.R;
import com.example.sistemacompraventa_v2.entidades.Publicacion;

import java.util.List;

public class AdaptadorBuscar extends RecyclerView.Adapter< AdaptadorBuscar.MyViewHolder > {
    private List< Publicacion > publicaciones;
    Context viewContext;

    public AdaptadorBuscar( Context contextIn, List< Publicacion > publicacionesIn ) {
        viewContext = contextIn;
        publicaciones = publicacionesIn;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public MyViewHolder onCreateViewHolder( @NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType ) {
        LayoutInflater inflater = LayoutInflater.from( viewContext );
        View view = inflater.inflate( R.layout.card_row, parent, false );
        return new MyViewHolder( view );
    }

    @Override
    public void onBindViewHolder( @NonNull @org.jetbrains.annotations.NotNull AdaptadorBuscar.MyViewHolder holder, int position ) {
        holder.titulo.setText( publicaciones.get( position ).getNombre() );
        holder.descripcion.setText( publicaciones.get( position ).getDescripcion() );
        holder.precio.setText( Float.toString( publicaciones.get( position ).getPrecio() ) );
    }

    @Override
    public int getItemCount() {
        return publicaciones.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView titulo;
        private TextView descripcion;
        private TextView precio;
        private ImageView imagen;

        public MyViewHolder( @NonNull View itemView ) {
            super( itemView );
            titulo = itemView.findViewById( R.id.titulo );
            descripcion = itemView.findViewById( R.id.descripcion );
            precio = itemView.findViewById( R.id.precio );
            imagen = itemView.findViewById( R.id.imagenPublicacion );
        }
    }
}
