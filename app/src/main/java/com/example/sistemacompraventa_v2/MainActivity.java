package com.example.sistemacompraventa_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.sistemacompraventa_v2.sesionusuario.LoginSession;
import com.example.sistemacompraventa_v2.controladores.PrincipalFragmento;
import com.example.sistemacompraventa_v2.controladores.IniciarSesionFragmento;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        drawerLayout = findViewById( R.id.navigation_head );

        navigationView = findViewById( R.id.navigation_view );
        seleccionaMenuNavegacion();
        navigationView.setNavigationItemSelectedListener( this );
        getSupportFragmentManager().beginTransaction().replace( R.id.Fragment_container, new PrincipalFragmento() );
        Toolbar toolbar = findViewById( R.id.toolbar );

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drawerLayout, toolbar,
                                           R.string.navigation_draw_open, R.string.navigation_draw_close );

        drawerLayout.addDrawerListener( toggle );
        toggle.syncState();
        if( savedInstanceState == null ) {
            getSupportFragmentManager().beginTransaction().replace( R.id.Fragment_container, new PrincipalFragmento() ).commit();
            navigationView.setCheckedItem( R.id.home );
        }
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

    @Override
    public boolean onNavigationItemSelected( @NonNull MenuItem menuItem ) {
        switch( menuItem.getItemId() )
        {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace( R.id.Fragment_container, new PrincipalFragmento() ).commit();
                break;
            case R.id.iniciarSesion:
                getSupportFragmentManager().beginTransaction().replace( R.id.Fragment_container, new IniciarSesionFragmento() ).commit();
                break;
            case R.id.buscarProducto:
                break;
            case R.id.perfil:
                break;
            case R.id.carritoCompras:
                break;
            case R.id.favoritos:
                break;
            case R.id.pedidos:
                break;
            case R.id.historial:
                break;
            case R.id.cerrarSesion:
                LoginSession.GetInstance().Logout();
                setNonUserMenu();
                getSupportFragmentManager().beginTransaction().replace( R.id.Fragment_container, new PrincipalFragmento() ).commit();
                Toast.makeText( getBaseContext(), R.string.cerrando_sesion, Toast.LENGTH_SHORT ).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void seleccionaMenuNavegacion(){
        if( !LoginSession.GetInstance().IsLoggedIn() ) {
            setMenuNoUsuario();
        } else {
            setMenuUsuario();
        }
    }

    private void setMenuUsuario() {
        navigationView.getMenu().clear();
        navigationView.inflateMenu( R.menu.user_nav_menu );
    }

    private void setMenuNoUsuario() {
        navigationView.getMenu().clear();
        navigationView.inflateMenu( R.menu.non_user_nav_menu );
    }

    public void setUserMenu() {
        navigationView = findViewById( R.id.navigation_view );
        navigationView.getMenu().clear();
        navigationView.inflateMenu( R.menu.user_nav_menu );
        navigationView.setNavigationItemSelectedListener( this );
        navigationView.setCheckedItem( R.id.home );
    }

    public void setNonUserMenu() {
        navigationView = findViewById( R.id.navigation_view );
        navigationView.getMenu().clear();
        navigationView.inflateMenu( R.menu.non_user_nav_menu );
        navigationView.setNavigationItemSelectedListener( this );
        navigationView.setCheckedItem( R.id.home );
    }
}