package com.example.quickfleet.ui.rutas;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager; // Importar LayoutManager

import com.example.quickfleet.databinding.FragmentRutasBinding; // Binding para este fragment
import com.example.quickfleet.adapters.PedidoRealizadoAdapter; // Reutilizamos el adapter
import com.example.quickfleet.models.Pedido; // Reutilizamos el modelo

import java.util.ArrayList;

public class RutasFragment extends Fragment {

    private FragmentRutasBinding binding;

    // Variables para el RecyclerView
    private PedidoRealizadoAdapter completedAdapter;
    private ArrayList<Pedido> listaRutasCompletadas = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentRutasBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1. Configurar el RecyclerView con un LayoutManager
        binding.recyclerViewRutasCompletadas.setLayoutManager(new LinearLayoutManager(getContext()));

        // 2. Inicializar el Adapter con nuestra lista (inicialmente vacía)
        completedAdapter = new PedidoRealizadoAdapter(listaRutasCompletadas);

        // 3. Asignar el Adapter al RecyclerView
        binding.recyclerViewRutasCompletadas.setAdapter(completedAdapter);

        // 4. Cargar los datos
        loadCompletedRoutesData();
    }

    private void loadCompletedRoutesData() {
        // Simulación: crea datos de ejemplo si la lista está vacía
        if (listaRutasCompletadas.isEmpty()) {
            Log.d("RutasFragment", "Cargando datos de ejemplo...");
            // Usamos el constructor para pedidos realizados
            listaRutasCompletadas.add(new Pedido("R001", "Pedido de Negocio A 23/10/2025", "Av. Reforma 100", "Documentos urgentes"));
            listaRutasCompletadas.add(new Pedido("R002", "Pedido de Negocio A 22/10/2025", "Calle Madero 50", "Paquete de software"));
            listaRutasCompletadas.add(new Pedido("R003", "Pedido de Negocio A 21/10/2025", "Parque Hundido S/N", "Entrega especial"));
            listaRutasCompletadas.add(new Pedido("R004", "Pedido de Negocio A 20/10/2025", "Insurgentes Sur 123", "Material de oficina"));
        }

        // 5. Notifica al adapter que los datos cambiaron (¡MUY IMPORTANTE!)
        completedAdapter.notifyDataSetChanged();

        Log.d("RutasFragment", "Datos cargados. Total: " + completedAdapter.getItemCount());
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}