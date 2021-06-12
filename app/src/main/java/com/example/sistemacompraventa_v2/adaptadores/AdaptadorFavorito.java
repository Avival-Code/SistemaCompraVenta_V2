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
import com.example.sistemacompraventa_v2.VisualizarFavoritoActivity;
import com.example.sistemacompraventa_v2.entidades.Publicacion;
import com.example.sistemacompraventa_v2.sesionusuario.LoginSession;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdaptadorFavorito extends RecyclerView.Adapter< AdaptadorFavorito.MyViewHolder >{
    private Context viewContext;
    private List< Publicacion > publicaciones;

    public AdaptadorFavorito( Context contextIn ) {
        viewContext = contextIn;
        publicaciones = LoginSession.getInstance().getArticulosFavoritos();
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder( @NonNull @NotNull ViewGroup parent, int viewType ) {
        LayoutInflater inflater = LayoutInflater.from( viewContext );
        View view = inflater.inflate( R.layout.card_row, parent, false );
        return new AdaptadorFavorito.MyViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AdaptadorFavorito.MyViewHolder holder, int position) {
        holder.titulo.setText( publicaciones.get( position ).getNombre() );
        holder.descripcion.setText( publicaciones.get( position ).getDescripcion() );
        holder.precio.setText( Double.toString( publicaciones.get( position ).getPrecio() ) );

        holder.mainLayout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( viewContext, VisualizarFavoritoActivity.class );
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
        });
    }

    @Override
    public int getItemCount() {
        return publicaciones.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
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
}
