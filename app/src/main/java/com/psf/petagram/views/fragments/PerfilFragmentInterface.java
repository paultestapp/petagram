package com.psf.petagram.views.fragments;

import com.psf.petagram.adapters.FotoAdapter;
import com.psf.petagram.models.Foto;
import com.psf.petagram.models.Usuario;

import java.util.ArrayList;

/**
 * Created by paulsalcedo on 18/2/18.
 */

public interface PerfilFragmentInterface {

    public void updateUserData();

    public void makeRecyclerLayout();

    public FotoAdapter makeAdapter(ArrayList<Foto> fotos);

    public void setAdapter(FotoAdapter fotoAdapter);

    public void onLoadPhotos();
    public void onLoadPhotosSuccess();
    public void onLoadPhotosFail(String message);

}
