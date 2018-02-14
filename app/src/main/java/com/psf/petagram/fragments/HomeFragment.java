package com.psf.petagram.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.psf.petagram.R;
import com.psf.petagram.adapters.MascotaAdapter;
import com.psf.petagram.models.Mascota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rv_mascotas;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rv_mascotas = view.findViewById(R.id.rv_mascotas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_mascotas.setLayoutManager(layoutManager);

        setData();
        setAdapter();

        return view;
    }

    public void setAdapter() {
        MascotaAdapter mascotaAdapter = new MascotaAdapter(mascotas, getActivity());
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

}
