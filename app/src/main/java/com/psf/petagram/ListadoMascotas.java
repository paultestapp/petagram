package com.psf.petagram;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class ListadoMascotas extends AppCompatActivity {

    private Resources resources;

    private ArrayList<Mascota> mascotas;
    private RecyclerView rv_mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_mascotas);

        Toolbar mainActionbar = findViewById(R.id.main_actionbar);
        setSupportActionBar(mainActionbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        rv_mascotas = findViewById(R.id.rv_mascotas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_mascotas.setLayoutManager(layoutManager);

        setData();
        setAdapter();

    }

    public void setAdapter() {
        MascotaAdapter mascotaAdapter = new MascotaAdapter(mascotas, this);
        rv_mascotas.setAdapter(mascotaAdapter);
    }

    public void setData() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.pet_1, "Bequer", 5));
        mascotas.add(new Mascota(R.drawable.pet_2, "Arwen", 5));
        mascotas.add(new Mascota(R.drawable.pet_3, "Dixie", 5));
        mascotas.add(new Mascota(R.drawable.pet_5, "Ank", 5));
        mascotas.add(new Mascota(R.drawable.pet_8, "Yuu", 5));
    }
}
