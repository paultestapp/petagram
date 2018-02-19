package com.psf.petagram.restApi.models;

import com.psf.petagram.models.Foto;

import java.util.ArrayList;

/**
 * Created by paulsalcedo on 18/2/18.
 */

public class FotoResponse {

    ArrayList<Foto> fotos;

    public ArrayList<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(ArrayList<Foto> fotos) {
        this.fotos = fotos;
    }
}
