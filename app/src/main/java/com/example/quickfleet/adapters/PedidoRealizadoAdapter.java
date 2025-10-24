package com.example.quickfleet.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.quickfleet.R;
import com.example.quickfleet.models.Pedido;
import java.util.List;

public class PedidoRealizadoAdapter extends RecyclerView.Adapter<PedidoRealizadoAdapter.PedidoRealizadoViewHolder> {

    private List<Pedido> listaPedidos;

    public PedidoRealizadoAdapter(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    // --- ViewHolder Interno ---
    public static class PedidoRealizadoViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserDate, tvAddress, tvDescription; // Referencias a los TextViews del XML

        public PedidoRealizadoViewHolder(@NonNull View itemView) {
            super(itemView);
            // Encuentra los TextViews usando sus IDs del item_pedido_realizado.xml
            tvUserDate = itemView.findViewById(R.id.tvCompletedUserDate);
            tvAddress = itemView.findViewById(R.id.tvCompletedAddress);
            tvDescription = itemView.findViewById(R.id.tvCompletedDescription);
            // Agrega listeners si es necesario
        }
    }
    // --- Fin ViewHolder ---

    @NonNull
    @Override
    public PedidoRealizadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla el layout item_pedido_realizado.xml
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pedido_realizado, parent, false);
        return new PedidoRealizadoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PedidoRealizadoViewHolder holder, int position) {
        Pedido pedido = listaPedidos.get(position);

        // Asigna los datos del pedido a los TextViews
        holder.tvUserDate.setText(pedido.getUsuarioFecha() != null ? pedido.getUsuarioFecha() : "Fecha/Usuario no disponible");
        holder.tvAddress.setText(pedido.getDireccion() != null ? pedido.getDireccion() : "Dirección no disponible");
        holder.tvDescription.setText(pedido.getDescripcion() != null ? pedido.getDescripcion() : "Sin descripción");
    }

    @Override
    public int getItemCount() {
        return listaPedidos != null ? listaPedidos.size() : 0;
    }

    // Método para actualizar datos
    public void updateData(List<Pedido> nuevaLista) {
        this.listaPedidos = nuevaLista;
        notifyDataSetChanged();
    }
}