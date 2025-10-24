package com.example.quickfleet.ui.negocioconexion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConexionNegocioViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ConexionNegocioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}