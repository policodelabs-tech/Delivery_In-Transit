package com.example.quickfleet.ui.pedidos;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quickfleet.databinding.FragmentPedidosBinding;
// Importa ambos adapters
import com.example.quickfleet.adapters.PedidoPendienteAdapter;
import com.example.quickfleet.adapters.PedidoRealizadoAdapter; // Descomentado
import com.example.quickfleet.models.Pedido;

import java.util.ArrayList;

public class PedidosFragment extends Fragment implements View.OnClickListener {

    private FragmentPedidosBinding binding;

    private PedidoPendienteAdapter pendingAdapter;
    private PedidoRealizadoAdapter completedAdapter; // Descomentado
    private ArrayList<Pedido> listaPedidosPendientes = new ArrayList<>();
    private ArrayList<Pedido> listaPedidosRealizados = new ArrayList<>(); // Descomentado

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPedidosBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.cardCurrentOrder.setOnClickListener(this);
        binding.cardPendingOrders.setOnClickListener(this);
        binding.cardCompletedOrders.setOnClickListener(this);

        binding.recyclerViewPendingOrders.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerViewCompletedOrders.setLayoutManager(new LinearLayoutManager(getContext()));

        // --- Inicializar y asignar Adapters ---
        pendingAdapter = new PedidoPendienteAdapter(listaPedidosPendientes);
        binding.recyclerViewPendingOrders.setAdapter(pendingAdapter);

        completedAdapter = new PedidoRealizadoAdapter(listaPedidosRealizados); // Creado
        binding.recyclerViewCompletedOrders.setAdapter(completedAdapter);     // Asignado

        // Visibilidad inicial
        binding.layoutCurrentOrderDetails.setVisibility(View.GONE);
        binding.recyclerViewPendingOrders.setVisibility(View.GONE);
        binding.recyclerViewCompletedOrders.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == binding.cardCurrentOrder.getId()) {
            toggleVisibility(binding.layoutCurrentOrderDetails);
            if (binding.layoutCurrentOrderDetails.getVisibility() == View.VISIBLE) {
                Toast.makeText(getContext(), "Mostrando Pedido Actual...", Toast.LENGTH_SHORT).show();
                loadCurrentOrderData();
            } else {
                Toast.makeText(getContext(), "Ocultando Pedido Actual", Toast.LENGTH_SHORT).show();
            }

        } else if (id == binding.cardPendingOrders.getId()) {
            toggleVisibility(binding.recyclerViewPendingOrders);
            if (binding.recyclerViewPendingOrders.getVisibility() == View.VISIBLE) {
                Toast.makeText(getContext(), "Cargando Pedidos Pendientes...", Toast.LENGTH_SHORT).show();
                loadPendingOrdersData();
            } else {
                Toast.makeText(getContext(), "Ocultando Pedidos Pendientes", Toast.LENGTH_SHORT).show();
            }

        } else if (id == binding.cardCompletedOrders.getId()) {
            toggleVisibility(binding.recyclerViewCompletedOrders);
            if (binding.recyclerViewCompletedOrders.getVisibility() == View.VISIBLE) {
                Toast.makeText(getContext(), "Cargando Pedidos Realizados...", Toast.LENGTH_SHORT).show();
                // Llamar a la carga de datos realizados
                loadCompletedOrdersData();
            } else {
                Toast.makeText(getContext(), "Ocultando Pedidos Realizados", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void toggleVisibility(View viewToToggle) {
        // ... (igual que antes) ...
        if (viewToToggle.getVisibility() == View.VISIBLE) {
            viewToToggle.setVisibility(View.GONE);
        } else {
            viewToToggle.setVisibility(View.VISIBLE);
        }
    }

    // --- Funciones para cargar datos ---

    private void loadCurrentOrderData() {
        // ... (igual que antes) ...
        binding.tvCurrentOrderAddress.setText("Av. Siempre Viva 742,\nSpringfield, USA");
        binding.tvCurrentOrderDescription.setText("Una caja de donas glaseadas.");
        binding.tvCurrentOrderRecipient.setText("Homero Simpson");
        binding.tvCurrentOrderStatus.setText("En curso");
        Log.d("PedidosFragment", "Datos del pedido actual cargados (ejemplo).");
    }

    private void loadPendingOrdersData() {
        // ... (igual que antes) ...
        if (listaPedidosPendientes.isEmpty()) {
            listaPedidosPendientes.add(new Pedido("P001", "Pedido de 23/10/2025 10:00 Hrs", "Calle Falsa 123,\nColonia Centro", "Libro de Android", "Usuario A"));
            listaPedidosPendientes.add(new Pedido("P002", "Pedido de 23/10/2025 11:30 Hrs", "Blvd. Independencia 456,\nColonia Nueva", "Pizza grande", "Usuario B"));
            listaPedidosPendientes.add(new Pedido("P003", "Pedido de 23/10/2025 12:15 Hrs", "Callejón Diamante 7,\nBarrio Antiguo", "Flores", "Usuario C"));
        }
        pendingAdapter.notifyDataSetChanged();
        Log.d("PedidosFragment", "Datos pendientes cargados/actualizados (ejemplo). Items: " + pendingAdapter.getItemCount());
    }

    // --- Implementación de carga para Pedidos Realizados ---
    private void loadCompletedOrdersData() {
        // Simulación: crea datos de ejemplo si la lista está vacía
        if (listaPedidosRealizados.isEmpty()) {
            // Usamos el constructor para pedidos realizados
            listaPedidosRealizados.add(new Pedido("R001", "Pedido de 22/10/2025", "Av. Reforma 100", "Documentos urgentes"));
            listaPedidosRealizados.add(new Pedido("R002", "Pedido de 21/10/2025", "Calle Madero 50", "Comida china"));
            listaPedidosRealizados.add(new Pedido("R003", "Pedido de 20/10/2025", "Parque Hundido S/N", "Pastel de cumpleaños"));
        }
        // Notifica al adapter de realizados que los datos cambiaron
        completedAdapter.notifyDataSetChanged(); // ¡Importante!

        Log.d("PedidosFragment", "Datos realizados cargados/actualizados (ejemplo). Items: " + completedAdapter.getItemCount());
    }
    // --- Fin implementación ---

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}