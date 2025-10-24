package com.example.quickfleet;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    // Declaramos el TextView aquí para usar su ID en onClick
    TextView textViewNoAccount;
    Button buttonSignIn, buttonSignInN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // --- Referencias a los componentes de la UI ---
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignIn = findViewById(R.id.buttonSignIn);
        buttonSignInN = findViewById(R.id.buttonSignInN);
        // 1. Referencia al TextView
        textViewNoAccount = findViewById(R.id.textViewNoAccount);

        // Listener para el botón de Iniciar Sesión
        buttonSignIn.setOnClickListener(this);
        buttonSignInN.setOnClickListener(this);

        // Listener para el listener al TextView
        textViewNoAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // --- Lógica para el botón de Iniciar Sesión ---
        if (v.getId() == R.id.buttonSignIn) {

            // Lógica de inicio de sesión
            Toast.makeText(LoginActivity.this, "Inicio de sesión exitoso (simulado)", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, Main_Repartidor.class);
            startActivity(intent);

        }
        // --- Lógica para el texto "¿No tienes una cuenta?" ---
        else if (v.getId() == R.id.textViewNoAccount) {

            Toast.makeText(LoginActivity.this, "Abriendo pantalla de Registro", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.buttonSignInN){
            Toast.makeText(LoginActivity.this, "Inicio de sesión exitoso (simulado)", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, Main_Negocio.class);
            startActivity(intent);
        }

        // cuando se usa el ID de la vista, ya que el ID es único e inequívoco.
    }
}

