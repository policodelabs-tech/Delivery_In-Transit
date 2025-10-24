package com.example.quickfleet.ui.ubicacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.quickfleet.databinding.FragmentUbicacionBinding;


public class UbicacionFragment extends Fragment {

    private FragmentUbicacionBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UbicacionViewModel galleryViewModel =
                new ViewModelProvider(this).get(UbicacionViewModel.class);

        binding = FragmentUbicacionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}