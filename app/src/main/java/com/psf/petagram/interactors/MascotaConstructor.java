package com.psf.petagram.interactors;

import android.content.ContentValues;
import android.content.Context;

import com.psf.petagram.R;
import com.psf.petagram.models.Mascota;
import com.psf.petagram.models.MascotaTable;

import java.util.ArrayList;

/**
 * Created by paulsalcedo on 15/2/18.
 */

public class MascotaConstructor {

    private Context context;

    public MascotaConstructor(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> getMascotas() {
        MascotaTable table = new MascotaTable(context);

        ArrayList<Mascota> mascotas = table.getAll();
        if(mascotas.size() <= 0) {
            seeder(table);
            mascotas = table.getAll();
        }

        return mascotas;
    }

    public ArrayList<Mascota> getTopMascotas() {
        MascotaTable table = new MascotaTable(context);
        return table.getTopFive();
    }

    public void addLike(Mascota mascota) {
        MascotaTable table = new MascotaTable(context);
        table.addLike(mascota);
    }

    public int getLikes(Mascota mascota) {
        MascotaTable table = new MascotaTable(context);
        return table.getLikes(mascota);
    }


    private void seeder(MascotaTable table) {

        ArrayList<Mascota> mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.pet_7, "Takao", 0));
        mascotas.add(new Mascota(R.drawable.pet_1, "Bequer", 0));
        mascotas.add(new Mascota(R.drawable.pet_2, "Arwen", 0));
        mascotas.add(new Mascota(R.drawable.pet_3, "Dixie", 0));
        mascotas.add(new Mascota(R.drawable.pet_4, "Askar", 0));
        mascotas.add(new Mascota(R.drawable.pet_5, "Shizu", 5));
        mascotas.add(new Mascota(R.drawable.pet_6, "Kenji", 0));
        mascotas.add(new Mascota(R.drawable.pet_8, "Yuu", 0));

        for (Mascota mascota : mascotas) {
            ContentValues values = new ContentValues();
            values.put(MascotaTable.FOTO, mascota.getFoto());
            values.put(MascotaTable.NOMBRE, mascota.getNombre());
            values.put(MascotaTable.LIKES, mascota.getLikes());
            table.insertMascota(values);
        }
    }

}
