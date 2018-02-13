package com.psf.petagram;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName();
    private Resources resources;

    private ArrayList<Mascota> mascotas;
    private RecyclerView rv_mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mainActionbar = findViewById(R.id.main_actionbar);
        setSupportActionBar(mainActionbar);

        // Instance resources
        resources = getResources();

        rv_mascotas = findViewById(R.id.rv_mascotas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_mascotas.setLayoutManager(layoutManager);

        setData();
        setAdapter();
        addFab();
    }

    public void setAdapter() {
        MascotaAdapter mascotaAdapter = new MascotaAdapter(mascotas, this);
        rv_mascotas.setAdapter(mascotaAdapter);
    }

    public void setData() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.pet_7, "Takao", 4));
        mascotas.add(new Mascota(R.drawable.pet_1, "Bequer", 5));
        mascotas.add(new Mascota(R.drawable.pet_2, "Arwen", 5));
        mascotas.add(new Mascota(R.drawable.pet_3, "Dixie", 5));
        mascotas.add(new Mascota(R.drawable.pet_4, "Askar", 4));
        mascotas.add(new Mascota(R.drawable.pet_5, "Ank", 5));
        mascotas.add(new Mascota(R.drawable.pet_6, "Kenji", 4));
        mascotas.add(new Mascota(R.drawable.pet_8, "Yuu", 5));
    }

    public void addFab() {
        FloatingActionButton btnFab = findViewById(R.id.btn_fab);
    }

    public void fabAction(View view) {
        Snackbar.make(view, resources.getString(R.string.label_take_photo), Snackbar.LENGTH_LONG)
                .setAction(resources.getString(R.string.label_fav_action), new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i(TAG, "Click en snackbar");
                    }
                })
                .setActionTextColor(resources.getColor(R.color.colorPrimary))
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_topmascotas:
                Intent iListado = new Intent(MainActivity.this, ListadoMascotas.class);
                startActivity(iListado);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
