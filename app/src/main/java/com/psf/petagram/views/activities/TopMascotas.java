package com.psf.petagram.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.psf.petagram.R;
import com.psf.petagram.adapters.MascotaAdapter;
import com.psf.petagram.presenters.TopMascotasPresenter;
import com.psf.petagram.views.MascotasViewInterface;
import com.psf.petagram.models.Mascota;

import java.util.ArrayList;

public class TopMascotas extends AppCompatActivity implements MascotasViewInterface {

    private TopMascotasPresenter presenter;
    private RecyclerView rv_mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_mascotas);

        Toolbar mainActionbar = findViewById(R.id.main_actionbar);
        if(mainActionbar != null) setSupportActionBar(mainActionbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        rv_mascotas = findViewById(R.id.rv_topmascotas);
        presenter = new TopMascotasPresenter(this, getApplicationContext());

    }

    @Override
    public void makeRecyclerLayout() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_mascotas.setLayoutManager(layoutManager);
    }

    @Override
    public MascotaAdapter makeAdapter(ArrayList<Mascota> mascotas) {
        return new MascotaAdapter(mascotas, this);
    }

    @Override
    public void setAdapter(MascotaAdapter mascotaAdapter) {
        rv_mascotas.setAdapter(mascotaAdapter);
    }
}
