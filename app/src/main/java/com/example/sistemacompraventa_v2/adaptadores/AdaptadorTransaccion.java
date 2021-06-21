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

import com.example.sistemacompraventa_v2.DetallesPublicacionActivity;
import com.example.sistemacompraventa_v2.R;
import com.example.sistemacompraventa_v2.VisualizarTransaccionActivity;
import com.example.sistemacompraventa_v2.entidades.Transaccion;
import com.example.sistemacompraventa_v2.sesionusuario.LoginSession;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdaptadorTransaccion extends RecyclerView.Adapter< AdaptadorTransaccion.MyViewHolder > {
    Context viewContext;
    private List< Transaccion > transacciones;

    public AdaptadorTransaccion( Context contextIn ) {
        viewContext = contextIn;
        transacciones = LoginSession.getInstance().getTransaccionesUsuario();
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder( @NonNull @NotNull ViewGroup parent, int viewType ) {
        LayoutInflater inflater = LayoutInflater.from( viewContext );
        View view = inflater.inflate( R.layout.transaccion_card_row, parent, false );
        return new AdaptadorTransaccion.MyViewHolder( view );
    }

    @Override
    public void onBindViewHolder( @NonNull @NotNull AdaptadorTransaccion.MyViewHolder holder, final int position ) {
        holder.claveTransaccion.setText( Integer.toString( transacciones.get( position ).getClaveTransaccion() ) );
        holder.fecha.setText( transacciones.get( position ).getFecha() );
        holder.total.setText( Double.toString( transacciones.get( position ).getTotal() ) );

        holder.mainLayout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent intent = new Intent( viewContext, VisualizarTransaccionActivity.class );
                intent.putExtra( "clave_transaccion", transacciones.get( position ).getClaveTransaccion() );
                intent.putExtra( "clave_vendedor", transacciones.get( position ).getClaveVendedor() );
                intent.putExtra( "direccion_comprador", transacciones.get( position ).getDireccionComprador() );
                intent.putExtra( "fecha", transacciones.get( position ).getFecha() );
                intent.putExtra( "total", transacciones.get( position ).getTotal() );
                intent.putExtra( "usuario_evaluado", transacciones.get( position ).getEvaluado() );
                viewContext.startActivity( intent );
            }
        } );
    }

    @Override
    public int getItemCount() { return transacciones.size(); }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView claveTransaccion;
        TextView fecha;
        TextView total;
        ImageView imagen;
        ConstraintLayout mainLayout;

        public MyViewHolder( @NonNull View itemView ) {
            super( itemView );
            claveTransaccion = itemView.findViewById( R.id.clave_transaccion_card );
            fecha = itemView.findViewById( R.id.fecha_transaccion_card );
            total = itemView.findViewById( R.id.total_transaccion_card );
            imagen = itemView.findViewById( R.id.imagenPublicacion );
            mainLayout = itemView.findViewById( R.id.mainLayout );
        }
    }
}
