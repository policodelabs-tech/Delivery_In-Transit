package com.example.quickfleet;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.quickfleet.databinding.ActivityMainNegocioBinding;
import com.google.android.material.navigation.NavigationView;

public class Main_Negocio extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainNegocioBinding binding;
    private NavController navController;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainNegocioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMainNegocio.toolbar);

        // --- Código del FAB eliminado ---

        drawerLayout = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // --- IDs actualizados para el menú de Negocio ---
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_conexion_negocio, R.id.nav_ubicacion, R.id.nav_rutas, R.id.nav_asignacion)
                .setOpenableLayout(drawerLayout)
                .build();

        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_negocio);

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // --- Manejo manual del menú para incluir "Salir" ---
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_Salir) { // Asegúrate que este ID exista en tu menú
                    // Acción para Salir
                    Intent intent = new Intent(Main_Negocio.this, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                } else {
                    // Manejo automático para los demás ítems
                    boolean handled = NavigationUI.onNavDestinationSelected(item, navController);
                    if (handled) {
                        drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    return handled;
                }
            }
        });
        // --- Fin del manejo manual ---
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla el menú correcto (el de 3 puntos, si tienes uno)
        getMenuInflater().inflate(R.menu.main__negocio, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}