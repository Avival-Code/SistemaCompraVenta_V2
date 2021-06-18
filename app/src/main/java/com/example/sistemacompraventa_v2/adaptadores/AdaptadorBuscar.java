package com.example.sistemacompraventa_v2.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistemacompraventa_v2.DetallesPublicacionActivity;
import com.example.sistemacompraventa_v2.R;
import com.example.sistemacompraventa_v2.entidades.Publicacion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AdaptadorBuscar extends RecyclerView.Adapter< AdaptadorBuscar.MyViewHolder > implements Filterable {
    private List< Publicacion > publicaciones;
    private List< Publicacion > publicacionesTodas;
    Context viewContext;

    public AdaptadorBuscar( Context contextIn, List< Publicacion > publicacionesIn ) {
        viewContext = contextIn;
        publicaciones = publicacionesIn;
        publicacionesTodas = new ArrayList<>( publicacionesIn );
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
        LayoutInflater inflater = LayoutInflater.from( viewContext );
        View view = inflater.inflate( R.layout.card_row, parent, false );
        return new AdaptadorBuscar.MyViewHolder( view );
    }

    @Override
    public void onBindViewHolder( @NonNull MyViewHolder holder, final int position ) {
        holder.titulo.setText( publicaciones.get( position ).getNombre() );
        holder.descripcion.setText( publicaciones.get( position ).getDescripcion() );
        holder.precio.setText( Double.toString( publicaciones.get( position ).getPrecio() ) );

        holder.mainLayout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent intent = new Intent( viewContext, DetallesPublicacionActivity.class );
                intent.putExtra( "clave_publicacion", publicaciones.get( position ).getClave_publicacion() );
                intent.putExtra( "nombre", publicaciones.get( position ).getNombre() );
                intent.putExtra( "descripcion", publicaciones.get( position ).getDescripcion() );
                intent.putExtra( "categoria", publicaciones.get( position ).getCategoria().ordinal() );
                intent.putExtra( "precio", publicaciones.get( position ).getPrecio() );
                intent.putExtra( "cantidad_disponible", publicaciones.get( position ).getCantidad_disponible() );
                intent.putExtra( "calificacion", publicaciones.get( position ).getCalificacion_general() );
                intent.putExtra( "unidad_medida", publicaciones.get( position ).getUnidad_medida() );
                intent.putExtra( "numero_ventas", publicaciones.get( position ).getNumero_ventas() );
                intent.putExtra( "imagen", publicaciones.get( position ).getImagen() );
                viewContext.startActivity( intent );
            }
        } );
    }

    @Override
    public int getItemCount() {
        return publicaciones.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titulo;
        TextView descripcion;
        TextView precio;
        ImageView imagen;
        ConstraintLayout mainLayout;

        public MyViewHolder( @NonNull View itemView ) {
            super( itemView );
            titulo = itemView.findViewById( R.id.titulo );
            descripcion = itemView.findViewById( R.id.descripcion );
            precio = itemView.findViewById( R.id.precio );
            imagen = itemView.findViewById( R.id.imagenPublicacion );
            mainLayout = itemView.findViewById( R.id.mainLayout );
        }
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering( CharSequence constraint ) {
            List< Publicacion > publicacionesFiltradas = new ArrayList<>();
            if( constraint.toString().isEmpty() ) {
                publicacionesFiltradas.addAll( publicacionesTodas );
            } else {
                for( Publicacion publicacion : publicacionesTodas ) {
                    if( publicacion.getNombre().toLowerCase().contains( constraint.toString().toLowerCase() ) ) {
                        publicacionesFiltradas.add( publicacion );
                    }
                }
            }
            FilterResults resultadosFiltrados = new FilterResults();
            resultadosFiltrados.values = publicacionesFiltradas;
            return resultadosFiltrados;
        }

        @Override
        protected void publishResults( CharSequence constraint, FilterResults results ) {
            publicaciones.clear();
            publicaciones.addAll( ( Collection< ? extends Publicacion > ) results.values );
            notifyDataSetChanged();
        }
    };
}
