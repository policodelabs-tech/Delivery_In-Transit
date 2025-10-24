package com.example.quickfleet.ui.negocioconexion;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.quickfleet.databinding.FragmentConexionClaveBinding;

public class ConexionClaveFragment extends Fragment {

    private FragmentConexionClaveBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentConexionClaveBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // TODO: Cargar la clave real generada y mostrarla en el TextView
        // binding.tvCodigoGenerado.setText(claveGenerada);

        binding.btnCopiarCodigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                copiarAlPortapapeles(binding.tvCodigoGenerado.getText().toString());
            }
        });

        binding.btnCompartirCodigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compartirCodigo(binding.tvCodigoGenerado.getText().toString());
            }
        });
    }

    private void copiarAlPortapapeles(String texto) {
        ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Código QuickFleet", texto);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(getContext(), "Código copiado al portapapeles", Toast.LENGTH_SHORT).show();
    }

    private void compartirCodigo(String texto) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Este es mi código de negocio de QuickFleet: " + texto);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, "Compartir código vía...");
        startActivity(shareIntent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}