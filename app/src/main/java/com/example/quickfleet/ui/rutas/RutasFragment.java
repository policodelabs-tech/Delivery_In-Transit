package com.example.quickfleet.ui.rutas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.quickfleet.databinding.FragmentRutasBinding;


public class RutasFragment extends Fragment {

    private FragmentRutasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RutasViewModel slideshowViewModel =
                new ViewModelProvider(this).get(RutasViewModel.class);

        binding = FragmentRutasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}