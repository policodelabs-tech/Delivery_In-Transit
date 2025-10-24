package com.example.quickfleet;

import android.content.Intent; // Importar Intent
import android.os.Bundle;
import android.view.MenuItem; // Importar MenuItem
import android.view.View;
import android.view.Menu;
import androidx.annotation.NonNull; // Importar NonNull
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat; // Importar GravityCompat
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.example.quickfleet.databinding.ActivityMainRepartidorBinding;

public class Main_Repartidor extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainRepartidorBinding binding;
    private NavController navController; // Hacemos NavController una variable miembro
    private DrawerLayout drawerLayout; // Hacemos DrawerLayout una variable miembro

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainRepartidorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMainRepartidor.toolbar);

        drawerLayout = binding.drawerLayout; // Asignamos a la variable miembro
        NavigationView navigationView = binding.navView;

        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_conexion, R.id.nav_pedidos, R.id.nav_servicio) // IDs de nivel superior
                .setOpenableLayout(drawerLayout)
                .build();

        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_repartidor); // Asignamos a la variable miembro

        // Configurar ActionBar y NavigationView
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        // *Quitamos la configuración automática de NavigationView aquí para manejar 'Salir' manualmente*
        // NavigationUI.setupWithNavController(navigationView, navController);

        // --- INICIO: Manejo Manual de NavigationView para 'Salir' ---
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_Salir) {
                    // Acción para Salir
                    Intent intent = new Intent(Main_Repartidor.this, LoginActivity.class);
                    // Limpia las actividades anteriores para que no pueda volver con el botón atrás
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish(); // Cierra esta actividad (Main_Repartidor)
                    drawerLayout.closeDrawer(GravityCompat.START); // Cierra el drawer
                    return true; // Indicamos que hemos manejado el evento
                } else {
                    // Para los otros items, dejamos que NavigationUI los maneje
                    boolean handled = NavigationUI.onNavDestinationSelected(item, navController);
                    if (handled) {
                        // Si NavigationUI lo manejó, cerramos el drawer
                        drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    // Devolvemos si fue manejado o no por NavigationUI
                    return handled;
                }
            }
        });
        // --- FIN: Manejo Manual ---
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main__repartidor, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Aseguramos que el botón de hamburguesa/flecha funcione correctamente
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    // Opcional: Para cerrar el drawer si se presiona el botón 'Atrás' mientras está abierto
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}