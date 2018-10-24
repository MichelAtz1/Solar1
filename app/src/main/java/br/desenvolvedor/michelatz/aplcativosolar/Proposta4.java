package br.desenvolvedor.michelatz.aplcativosolar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Proposta4 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposta4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("HCC SOLAR");
        toolbar.setSubtitle("Proposta - Passo 4");
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.listViewDadosUnidade);

        List<Dados> zombies = gerarZombies();
        ArrayAdapter<Dados> zombiesAdapter = new ArrayAdapter<Dados>(this, android.R.layout.simple_list_item_1, zombies);
        listView.setAdapter(zombiesAdapter);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent it = new Intent(this, Proposta3.class);
            startActivity(it);
            finish();
            super.onBackPressed();
        }
    }

    private List<Dados> gerarZombies() {
        List<Dados> zombies = new ArrayList<Dados>();
        zombies.add(criarZombie("Dados 1"));
        zombies.add(criarZombie("Dados 2"));
        zombies.add(criarZombie("Dados 3"));

        return zombies;
    }

    private Dados criarZombie(String nome) {
        Dados zombie = new Dados(nome);
        return zombie;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_1) {
            SharedPreferences sharedpreferences = getSharedPreferences(Inicial.MyPREFERENCES, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.remove("idPropostaKey");
            editor.commit();
            editor.clear();

            Inicial inic = new Inicial();
            inic.criarPropostaBanco();

            Intent it = new Intent(this, Proposta1.class);
            startActivity(it);
            finish();
        } else if (id == R.id.nav_2) {
            SharedPreferences sharedpreferences = getSharedPreferences(Inicial.MyPREFERENCES, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.remove("idPropostaKey");
            editor.commit();
            editor.clear();

            Intent it = new Intent(this, ListaPropostas.class);
            startActivity(it);
            finish();

        }/* else if (id == R.id.nav_3) {
            SharedPreferences sharedpreferences = getSharedPreferences(Inicial.MyPREFERENCES, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.remove("idPropostaKey");
            editor.commit();
            editor.clear();

        } else if (id == R.id.nav_4) {
            SharedPreferences sharedpreferences = getSharedPreferences(Inicial.MyPREFERENCES, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.remove("idPropostaKey");
            editor.commit();
            editor.clear();

        }*/ else if (id == R.id.nav_sair) {
            Intent it = new Intent(this, Proposta3.class);
            startActivity(it);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void adicionarDados(View v) {
        Intent it = new Intent(this, AdicionaDados.class);
        startActivity(it);
        finish();
    }
}
