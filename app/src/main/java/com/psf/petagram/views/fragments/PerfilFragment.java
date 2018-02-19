package com.psf.petagram.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.psf.petagram.R;
import com.psf.petagram.adapters.FotoAdapter;
import com.psf.petagram.models.Foto;
import com.psf.petagram.models.Usuario;
import com.psf.petagram.presenters.PerfilFragmentPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment implements PerfilFragmentInterface {

    private boolean isShow = false;

    private CircularImageView civ_photo_perfil;
    private TextView tv_name;
    private ProgressBar pb_perfil;

    private ArrayList<Foto> fotos;
    private RecyclerView rv_fotos;

    private PerfilFragmentPresenter presenter;
    private Usuario usuario;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        civ_photo_perfil = view.findViewById(R.id.civ_photo_perfil);
        tv_name = view.findViewById(R.id.tv_name);
        pb_perfil = view.findViewById(R.id.pb_perfil);
        pb_perfil.setVisibility(View.GONE);

        rv_fotos = view.findViewById(R.id.rv_fotos);

        presenter = new PerfilFragmentPresenter(this, getContext());

        return view;
    }

    public void showUser() {
        usuario = presenter.getUsuario();
        if (!usuario.getFull_name().isEmpty() && isShow) {
            Glide.with(this)
                    .load(usuario.getProfile_picture())
                    .apply(new RequestOptions().placeholder(R.drawable.ic_camera_24dp))
                    .into(civ_photo_perfil);
            tv_name.setText(usuario.getFull_name());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        isShow = true;
        showUser();
    }

    @Override
    public void onStop() {
        super.onStop();
        isShow = false;
    }

    // ---------------------------------------------------------------------------

    @Override
    public void updateUserData() {
        usuario = presenter.getUsuario();
        showUser();
    }

    // ---------------------------------------------------------------------------

    @Override
    public void makeRecyclerLayout() {
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        rv_fotos.setLayoutManager(layoutManager);
    }

    @Override
    public FotoAdapter makeAdapter(ArrayList<Foto> fotos) {
        return new FotoAdapter(fotos);
    }

    @Override
    public void setAdapter(FotoAdapter fotoAdapter) {
        rv_fotos.setAdapter(fotoAdapter);
    }

    @Override
    public void onLoadPhotos() {
        pb_perfil.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoadPhotosSuccess() {
        pb_perfil.setVisibility(View.GONE);
    }

    @Override
    public void onLoadPhotosFail(String message) {
        pb_perfil.setVisibility(View.GONE);
    }


}
