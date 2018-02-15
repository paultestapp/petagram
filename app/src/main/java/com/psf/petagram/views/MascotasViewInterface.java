package com.psf.petagram.views;

import com.psf.petagram.adapters.MascotaAdapter;
import com.psf.petagram.models.Mascota;

import java.util.ArrayList;

/**
 * Created by paulsalcedo on 15/2/18.
 */

public interface MascotasViewInterface {

    public void makeRecyclerLayout();

    public MascotaAdapter makeAdapter(ArrayList<Mascota> mascotas);

    public void setAdapter(MascotaAdapter mascotaAdapter);

}
