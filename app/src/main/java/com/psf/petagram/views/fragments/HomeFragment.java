package com.psf.petagram.views.fragments;


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
import com.psf.petagram.presenters.HomeFragmentPresenter;
import com.psf.petagram.views.MascotasViewInterface;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements MascotasViewInterface {

    private RecyclerView rv_mascotas;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rv_mascotas = view.findViewById(R.id.rv_mascotas);
        new HomeFragmentPresenter(this, getContext());
        return view;
    }

    @Override
    public void makeRecyclerLayout() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_mascotas.setLayoutManager(layoutManager);
    }

    @Override
    public MascotaAdapter makeAdapter(ArrayList<Mascota> mascotas) {
        return new MascotaAdapter(mascotas, getActivity());
    }

    @Override
    public void setAdapter(MascotaAdapter mascotaAdapter) {
        rv_mascotas.setAdapter(mascotaAdapter);
    }

}
