package com.example.quickfleet.ui.asignacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.quickfleet.databinding.FragmentAsignacionBinding;
import com.example.quickfleet.databinding.FragmentConexionNegocioBinding;

public class AsignacionFragment extends Fragment {

    private FragmentAsignacionBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AsignacionViewModel homeViewModel =
                new ViewModelProvider(this).get(AsignacionViewModel.class);

        binding = FragmentAsignacionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}