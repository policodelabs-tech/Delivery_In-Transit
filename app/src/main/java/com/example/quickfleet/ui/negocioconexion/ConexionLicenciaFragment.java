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
import com.example.quickfleet.databinding.FragmentConexionLicenciaBinding;

public class ConexionLicenciaFragment extends Fragment {

    private FragmentConexionLicenciaBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentConexionLicenciaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnRegistrarLicencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Añadir lógica para validar el código de licencia aquí

                String licencia = binding.etCodigoLicencia.getText().toString();

                if (licencia.isEmpty()) {
                    Toast.makeText(getContext(), "Por favor, inserta un código de licencia", Toast.LENGTH_SHORT).show();
                } else {
                    // Navega al siguiente fragmento (el formulario de datos)
                    NavController navController = Navigation.findNavController(v);
                    navController.navigate(R.id.action_licencia_to_datos);
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}