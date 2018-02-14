package com.psf.petagram.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.psf.petagram.R;
import com.psf.petagram.adapters.FotoAdapter;
import com.psf.petagram.models.Foto;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private ArrayList<Foto> fotos;
    private RecyclerView rv_fotos;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        rv_fotos = view.findViewById(R.id.rv_fotos);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        rv_fotos.setLayoutManager(layoutManager);

        setData();
        setAdapter();

        return view;
    }

    public void setAdapter() {
        FotoAdapter fotoAdapter = new FotoAdapter(fotos);
        rv_fotos.setAdapter(fotoAdapter);
    }

    public void setData() {
        fotos = new ArrayList<>();
        fotos.add(new Foto(R.drawable.pet_5, 5));
        fotos.add(new Foto(R.drawable.pet_5, 0));
        fotos.add(new Foto(R.drawable.pet_5, 3));
        fotos.add(new Foto(R.drawable.pet_5, 4));
        fotos.add(new Foto(R.drawable.pet_5, 1));
        fotos.add(new Foto(R.drawable.pet_5, 3));
        fotos.add(new Foto(R.drawable.pet_5, 2));
        fotos.add(new Foto(R.drawable.pet_5, 0));
        fotos.add(new Foto(R.drawable.pet_5, 5));
        fotos.add(new Foto(R.drawable.pet_5, 3));
        fotos.add(new Foto(R.drawable.pet_5, 2));
        fotos.add(new Foto(R.drawable.pet_5, 5));
    }

}
