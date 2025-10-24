package com.example.quickfleet.ui.asignacion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AsignacionViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AsignacionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}