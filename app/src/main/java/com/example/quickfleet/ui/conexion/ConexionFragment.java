package com.example.quickfleet.ui.conexion; // Asegúrate que el paquete sea correcto

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast; // Importar Toast

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

// Importar la clase de Binding generada para fragment_conexion.xml
import com.example.quickfleet.databinding.FragmentConexionBinding;

public class ConexionFragment extends Fragment implements View.OnClickListener {

    // Variable para el View Binding
    private FragmentConexionBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout usando View Binding
        binding = FragmentConexionBinding.inflate(inflater, container, false);
        // Devolver la vista raíz del binding
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Configurar OnClickListener para el botón "Regístrate"
        // Usamos 'binding' para acceder al botón definido en el XML
        binding.buttonRegisterBusiness.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Verificamos si el ID de la vista presionada es el del botón "Regístrate"
        if (v.getId() == binding.buttonRegisterBusiness.getId()) {
            // Acción para el botón Regístrate
            Toast.makeText(getContext(), "registro completado", Toast.LENGTH_SHORT).show();
            // Aquí, en el futuro, iría la lógica para verificar el código del negocio
            // y registrar la conexión.
        }
    }

    // Método para limpiar el binding cuando la vista del fragmento se destruye
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Importante para evitar fugas de memoria
    }
}