package com.example.sistemacompraventa_v2;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        drawerLayout = findViewById( R.id.navigation_head );
        Toolbar toolbar = findViewById( R.id.toolbar );

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drawerLayout, toolbar,
                                           R.string.navigation_draw_open, R.string.navigation_draw_close );

        drawerLayout.addDrawerListener( toggle );
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if( drawerLayout.isDrawerOpen( GravityCompat.START ) ) {
            drawerLayout.closeDrawer( GravityCompat.START );
        }
        else {
            super.onBackPressed();
        }
    }

    private void selecionaMenuNavegacion(){

    }

    private void creaMenuUsuario() {

    }

    private void creaMenuNoUsuario() {
        drawerLayout = findViewById( R.id.navigation_head );
        Toolbar toolbar = findViewById( R.id.toolbar );

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drawerLayout, toolbar,
                R.string.navigation_draw_open, R.string.navigation_draw_close );

        drawerLayout.addDrawerListener( toggle );
        toggle.syncState();
    }
}