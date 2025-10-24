package com.example.quickfleet.ui.servicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView; // Importar AdapterView
import android.widget.ArrayAdapter; // Importar ArrayAdapter
import android.widget.Spinner;      // Importar Spinner
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.quickfleet.R; // Importar R
import com.example.quickfleet.databinding.FragmentServicioBinding;

import java.util.Arrays;
import java.util.List;

public class ServicioFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener { // Implementar también OnItemSelectedListener

    private FragmentServicioBinding binding;
    private ArrayAdapter<CharSequence> timeAdapter; // Adapter para los Spinners

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentServicioBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // --- Configurar Listeners para los botones ---
        binding.buttonAvailable.setOnClickListener(this);
        binding.buttonOnBreak.setOnClickListener(this);
        binding.buttonOutOfService.setOnClickListener(this);

        // --- Configurar los Spinners ---
        // 1. Crear el ArrayAdapter usando el array de strings y un layout simple
        timeAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.schedule_times, android.R.layout.simple_spinner_item);
        // Especificar el layout a usar cuando aparece la lista de opciones
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 2. Obtener la lista de todos los Spinners para aplicarles el adapter y listener
        List<Spinner> allSpinners = Arrays.asList(
                binding.spinnerLunesInicio, binding.spinnerMartesInicio, binding.spinnerMiercolesInicio, binding.spinnerJuevesInicio, binding.spinnerSabadoInicio, binding.spinnerDomingoInicio,
                binding.spinnerLunesDescanso, binding.spinnerMartesDescanso, binding.spinnerMiercolesDescanso, binding.spinnerJuevesDescanso, binding.spinnerSabadoDescanso, binding.spinnerDomingoDescanso,
                binding.spinnerLunesFin, binding.spinnerMartesFin, binding.spinnerMiercolesFin, binding.spinnerJuevesFin, binding.spinnerSabadoFin, binding.spinnerDomingoFin
        );

        // 3. Aplicar el adapter y el listener a cada Spinner
        for (Spinner spinner : allSpinners) {
            spinner.setAdapter(timeAdapter);
            spinner.setOnItemSelectedListener(this); // Usar el listener del fragmento
            // TODO: Cargar la hora previamente guardada para este spinner si existe
            // spinner.setSelection(obtenerPosicionGuardadaPara(spinner.getId()));
        }
    }

    // --- Manejador para los clics en los BOTONES ---
    @Override
    public void onClick(View v) {
        int id = v.getId();
        // ... (lógica de los botones Disponible, En descanso, Sin servicio - igual que antes) ...
        if (id == binding.buttonAvailable.getId()) {
            Toast.makeText(getContext(), "Estado cambiado a: Disponible", Toast.LENGTH_SHORT).show();
        } else if (id == binding.buttonOnBreak.getId()) {
            Toast.makeText(getContext(), "Estado cambiado a: En descanso", Toast.LENGTH_SHORT).show();
        } else if (id == binding.buttonOutOfService.getId()) {
            Toast.makeText(getContext(), "Estado cambiado a: Sin servicio", Toast.LENGTH_SHORT).show();
        }
    }

    // --- Manejador para las SELECCIONES en los SPINNERS ---
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Obtener la hora seleccionada
        String selectedTime = parent.getItemAtPosition(position).toString();
        // Obtener el ID del Spinner que disparó el evento
        int spinnerId = parent.getId();

        // Ignorar la selección inicial "Selecciona" (posición 0) si no quieres hacer nada
        if (position > 0) {
            String dayAndTimeSlot = getDayAndTimeSlotFromSpinnerId(spinnerId); // Función auxiliar para identificar el spinner
            Toast.makeText(getContext(), dayAndTimeSlot + ": " + selectedTime, Toast.LENGTH_SHORT).show();

            // TODO: Guardar la hora seleccionada (selectedTime) para el día y slot correspondientes (dayAndTimeSlot)
            // guardarHorario(dayAndTimeSlot, selectedTime);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // No hacer nada si no se selecciona nada
    }

    // Función auxiliar para obtener una descripción del Spinner basado en su ID
    private String getDayAndTimeSlotFromSpinnerId(int spinnerId) {
        if (spinnerId == R.id.spinnerLunesInicio) return "Lunes Inicio";
        if (spinnerId == R.id.spinnerMartesInicio) return "Martes Inicio";
        // ... añadir todos los demás IDs ...
        if (spinnerId == R.id.spinnerLunesDescanso) return "Lunes Descanso";
        // ...
        if (spinnerId == R.id.spinnerDomingoFin) return "Domingo Fin";
        return "Desconocido"; // Valor por defecto
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    // --- Métodos de ejemplo (necesitarías implementarlos) ---
    /*
    private void guardarHorario(String diaYSlot, String hora) {
        // Lógica para guardar la preferencia (SharedPreferences, Base de datos, etc.)
        Log.d("ServicioFragment", "Guardando para " + diaYSlot + ": " + hora);
    }

    private int obtenerPosicionGuardadaPara(int spinnerId) {
         // Lógica para recuperar la hora guardada y encontrar su posición en el adapter
         String horaGuardada = recuperarHoraGuardada(getDayAndTimeSlotFromSpinnerId(spinnerId));
         if (horaGuardada != null && timeAdapter != null) {
              return timeAdapter.getPosition(horaGuardada);
         }
         return 0; // Posición de "Selecciona" por defecto
    }
    */
}