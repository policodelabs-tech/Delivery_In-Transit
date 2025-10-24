package com.example.quickfleet.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.quickfleet.R; // Importa R
import com.example.quickfleet.models.Pedido; // Importa tu modelo
import java.util.List;

public class PedidoPendienteAdapter extends RecyclerView.Adapter<PedidoPendienteAdapter.PedidoViewHolder> {

    private List<Pedido> listaPedidos;

    // Constructor que recibe la lista de datos
    public PedidoPendienteAdapter(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    // --- ViewHolder Interno ---
    // Mantiene las referencias a las vistas (TextViews) dentro de cada ítem (fila)
    public static class PedidoViewHolder extends RecyclerView.ViewHolder {
        TextView tvDateTime, tvAddress, tvDescription, tvRequester; // Referencias a los TextViews del XML

        public PedidoViewHolder(@NonNull View itemView) {
            super(itemView);
            // Encuentra los TextViews usando sus IDs del item_pedido_pendiente.xml
            tvDateTime = itemView.findViewById(R.id.tvPendingDateTime);
            tvAddress = itemView.findViewById(R.id.tvPendingAddress);
            tvDescription = itemView.findViewById(R.id.tvPendingDescription);
            tvRequester = itemView.findViewById(R.id.tvPendingRequester);
            // Agrega aquí listeners si quieres que cada ítem sea clickable
            // itemView.setOnClickListener(...);
        }
    }
    // --- Fin ViewHolder ---

    // Infla (crea) el layout XML para cada ítem cuando es necesario
    @NonNull
    @Override
    public PedidoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla el layout item_pedido_pendiente.xml
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pedido_pendiente, parent, false);
        return new PedidoViewHolder(view);
    }

    // Vincula los datos de un Pedido específico a las vistas (TextViews) de un ViewHolder
    @Override
    public void onBindViewHolder(@NonNull PedidoViewHolder holder, int position) {
        // Obtiene el pedido de la lista según la posición
        Pedido pedido = listaPedidos.get(position);

        // Asigna los datos del pedido a los TextViews del ViewHolder
        holder.tvDateTime.setText(pedido.getFechaHora() != null ? pedido.getFechaHora() : "Fecha no disponible");
        holder.tvAddress.setText(pedido.getDireccion() != null ? pedido.getDireccion() : "Dirección no disponible");
        holder.tvDescription.setText(pedido.getDescripcion() != null ? pedido.getDescripcion() : "Sin descripción");
        holder.tvRequester.setText(pedido.getSolicitante() != null ? pedido.getSolicitante() : "");

        // Oculta el solicitante si no hay información (opcional)
        // holder.tvRequester.setVisibility(pedido.getSolicitante() != null && !pedido.getSolicitante().isEmpty() ? View.VISIBLE : View.GONE);
    }

    // Devuelve la cantidad total de ítems en la lista
    @Override
    public int getItemCount() {
        return listaPedidos != null ? listaPedidos.size() : 0;
    }

    // Método para actualizar la lista de datos (útil si cargas datos después)
    public void updateData(List<Pedido> nuevaLista) {
        this.listaPedidos = nuevaLista;
        notifyDataSetChanged(); // Notifica al RecyclerView que los datos cambiaron
    }
}