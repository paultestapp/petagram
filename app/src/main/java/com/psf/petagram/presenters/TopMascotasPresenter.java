package com.psf.petagram.presenters;

import android.content.Context;

import com.psf.petagram.interactors.MascotaConstructor;
import com.psf.petagram.models.Mascota;
import com.psf.petagram.views.MascotasViewInterface;

import java.util.ArrayList;

/**
 * Created by paulsalcedo on 15/2/18.
 */

public class TopMascotasPresenter implements TopMascotasPresenterInterface {

    private Context context;
    private MascotasViewInterface mascotasViewInterface;
    private MascotaConstructor mascotaConstructor;
    private ArrayList<Mascota> mascotas;

    public TopMascotasPresenter(MascotasViewInterface mascotasViewInterface, Context context) {
        this.mascotasViewInterface = mascotasViewInterface;
        this.context = context;

        mascotaConstructor = new MascotaConstructor(context);
        getMascotas();
    }

    @Override
    public void getMascotas() {
        mascotas = mascotaConstructor.getTopMascotas();
        showMascotas();
    }

    @Override
    public void showMascotas() {
        mascotasViewInterface.setAdapter(mascotasViewInterface.makeAdapter(mascotas));
        mascotasViewInterface.makeRecyclerLayout();
    }
}
