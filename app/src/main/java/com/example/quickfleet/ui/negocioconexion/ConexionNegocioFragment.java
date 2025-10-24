package com.example.quickfleet.ui.negocioconexion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.quickfleet.R;
import com.example.quickfleet.databinding.FragmentConexionNegocioBinding;

public class ConexionNegocioFragment extends Fragment {

    private FragmentConexionNegocioBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentConexionNegocioBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnGuardarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Añadir lógica para guardar todos los datos del formulario

                // Simulación de guardado exitoso
                Toast.makeText(getContext(), "Datos guardados", Toast.LENGTH_SHORT).show();

                // Navega al fragmento final (mostrar clave)
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_datos_to_clave);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}