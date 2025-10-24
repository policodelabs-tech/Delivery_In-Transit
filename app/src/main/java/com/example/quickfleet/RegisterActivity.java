package com.example.quickfleet;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonRegsiter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        buttonRegsiter = findViewById(R.id.buttonRegister);
        buttonRegsiter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Registro completado", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Redigrigiendo . . .", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(RegisterActivity.this, Main_Repartidor.class);
        startActivity(intent);
    }
}
